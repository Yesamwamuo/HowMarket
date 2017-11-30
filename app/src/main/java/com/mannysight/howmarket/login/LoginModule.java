package com.mannysight.howmarket.login;

import com.mannysight.howmarket.di.ActivityScoped;
import com.mannysight.howmarket.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by wamuo on 9/1/2017.
 */
@Module
public abstract class LoginModule {

  @FragmentScoped
  @ContributesAndroidInjector
  abstract LoginFragment loginFragment();

  @ActivityScoped
  @Binds
  abstract LoginContract.Presenter loginPresenter(LoginPresenter presenter);

}
