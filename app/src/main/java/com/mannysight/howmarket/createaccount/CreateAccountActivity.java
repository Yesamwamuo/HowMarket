package com.mannysight.howmarket.createaccount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.mannysight.howmarket.R;
import com.mannysight.howmarket.login.LoginFragment;
import com.mannysight.howmarket.util.ActivityUtils;
import javax.inject.Inject;

public class CreateAccountActivity extends AppCompatActivity {

  @Inject
  CreateAccountFragment injectedFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_account);

    CreateAccountFragment createAccountFragment = (CreateAccountFragment) getSupportFragmentManager()
        .findFragmentById(R.id.contentFrame);

    if (createAccountFragment == null) {
      createAccountFragment = injectedFragment;
      ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
          createAccountFragment, R.id.contentFrame);
    }
  }


  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}
