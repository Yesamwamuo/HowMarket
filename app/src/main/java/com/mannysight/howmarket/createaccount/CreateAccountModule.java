package com.mannysight.howmarket.createaccount;

import com.mannysight.howmarket.di.ActivityScoped;
import com.mannysight.howmarket.di.FragmentScoped;
import com.mannysight.howmarket.login.LoginContract;
import com.mannysight.howmarket.login.LoginFragment;
import com.mannysight.howmarket.login.LoginPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by wamuo on 10/15/2017.
 */

@Module
public abstract class CreateAccountModule {

  @FragmentScoped
  @ContributesAndroidInjector
  abstract CreateAccountFragment createAccountFragment();

  @ActivityScoped
  @Binds
  abstract CreateAccountContract.Presenter createAccountPresenter(CreateAccountPresenter presenter);
}
