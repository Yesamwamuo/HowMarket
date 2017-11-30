package com.mannysight.howmarket.login;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mannysight.howmarket.R;
import com.mannysight.howmarket.util.ActivityUtils;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends DaggerAppCompatActivity {

  @Inject
  LoginFragment injectedFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager()
        .findFragmentById(R.id.contentFrame);

    if (loginFragment == null) {
      loginFragment = injectedFragment;
      ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
          loginFragment, R.id.contentFrame);
    }
  }


  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}

