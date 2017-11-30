package com.mannysight.howmarket.login;

import android.support.annotation.StringRes;

import com.mannysight.howmarket.BasePresenter;
import com.mannysight.howmarket.BaseView;

/**
 * Created by wamuo on 8/27/2017.
 */

public interface LoginContract {

  interface View extends BaseView<Presenter> {

    void makeToast(@StringRes int stringId);

    void makeToast(String message);

    String getEmail();

    String getPassword();

    void startMainActivity();

    void startCreateAccountActivity();

    void showProgressIndicator(boolean show);

  }

  interface Presenter extends BasePresenter<View> {

    void onLogInClick();

    void onCreateClick();
  }
}

