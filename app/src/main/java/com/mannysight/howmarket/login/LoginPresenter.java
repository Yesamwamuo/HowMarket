package com.mannysight.howmarket.login;

import android.support.annotation.Nullable;

import com.mannysight.howmarket.R;
import com.mannysight.howmarket.data.auth.AuthSource;
import com.mannysight.howmarket.data.auth.Credentials;
import com.mannysight.howmarket.util.BaseSchedulerProvider;

import io.reactivex.observers.DisposableCompletableObserver;
import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by wamuo on 9/1/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {

  private AuthSource authSource;
  private CompositeDisposable compositeDisposable;
  private BaseSchedulerProvider schedulerProvider;

  @Nullable
  private LoginContract.View view;


  @Inject
  public LoginPresenter(AuthSource authSource,
      BaseSchedulerProvider schedulerProvider) {
    this.authSource = authSource;
    this.schedulerProvider = schedulerProvider;
    this.compositeDisposable = new CompositeDisposable();
  }

  @Override
  public void onLogInClick() {
    String userEmail = view.getEmail();
    String userPassword = view.getPassword();
    if (userEmail.isEmpty()) {
      view.makeToast(R.string.error_empty_input);
    } else if (userPassword.isEmpty()) {
      view.makeToast(R.string.error_empty_input);
    } else if (!userEmail.contains("@")) {
      view.makeToast(R.string.error_invalid_email);
    } else if (userPassword.length() > 19) {
      view.makeToast(R.string.error_password_too_long);
    } else {
      attemptLogIn(new Credentials(userPassword, "", userEmail));
    }

  }

  private void attemptLogIn(Credentials credentials) {
    view.showProgressIndicator(true);
    compositeDisposable.add(
        authSource.attemptLogin(credentials)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribeWith(new DisposableCompletableObserver() {
              @Override
              public void onComplete() {
                view.showProgressIndicator(false);
                view.startMainActivity();
              }

              @Override
              public void onError(Throwable e) {
                view.showProgressIndicator(false);
                view.makeToast(e.toString());
              }
            })
    );

  }

  @Override
  public void onCreateClick() {

  }

  @Override
  public void takeView(LoginContract.View view) {

  }

  @Override
  public void dropView() {

  }

}
