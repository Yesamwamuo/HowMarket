package com.mannysight.howmarket.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mannysight.howmarket.MainActivity;
import com.mannysight.howmarket.R;

import com.mannysight.howmarket.createaccount.CreateAccountActivity;
import com.mannysight.howmarket.di.ActivityScoped;
import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
@ActivityScoped
public class LoginFragment extends DaggerFragment implements LoginContract.View {

  @BindView(R.id.activity_login_loginButton)
  Button login;

  @BindView(R.id.activity_login_registerButton)
  Button register;

  @BindView(R.id.activity_login_userEmail)
  EditText email;

  @BindView(R.id.activity_login_userPassword)
  EditText password;

  @BindView(R.id.pro_login_loading)
  ProgressBar progressBar;


  @Inject
  LoginContract.Presenter mPresenter;

  @Inject
  public LoginFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_login, container, false);
    ButterKnife.bind(this, rootView);

    register.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        mPresenter.onCreateClick();
      }
    });

    login.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        mPresenter.onLogInClick();
      }
    });

    email.requestFocus();

    return rootView;
  }


  @Override
  public void onResume() {
    super.onResume();
    mPresenter.takeView(this);
  }

  @Override
  public void onDestroy() {
    mPresenter.dropView();
    super.onDestroy();
  }

  @Override
  public void makeToast(@StringRes int stringId) {
    Toast.makeText(getActivity().getApplicationContext(), getString(stringId), Toast.LENGTH_SHORT).show();
  }

  @Override
  public void makeToast(String message) {
    Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
  }

  @Override
  public String getEmail() {
    return email.getText().toString();
  }

  @Override
  public String getPassword() {
    return password.getText().toString();
  }

  @Override
  public void startMainActivity() {
    Intent i = new Intent(getActivity(), MainActivity.class);
    startActivity(i);
  }

  @Override
  public void startCreateAccountActivity() {
    Intent i = new Intent(getActivity(), CreateAccountActivity.class);
    startActivity(i);
  }

  @Override
  public void showProgressIndicator(boolean show) {

  }
}
