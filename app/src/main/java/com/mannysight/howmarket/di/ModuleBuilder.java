package com.mannysight.howmarket.di;

import com.mannysight.howmarket.MainActivity;
import com.mannysight.howmarket.login.LoginActivity;
import com.mannysight.howmarket.login.LoginModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by wamuo on 8/27/2017.
 */


@Module
public abstract class ModuleBuilder {


  @ActivityScoped
  @ContributesAndroidInjector(modules = LoginModule.class)
  abstract LoginActivity loginActivity();

//    @ContributesAndroidInjector(modules = MainActivityModule.class)
//    abstract MainActivity bindMainActivity();
//
//    @ContributesAndroidInjector(modules = {DetailActivityModule.class, DetailFragmentProvider.class})
//    abstract DetailActivity bindDetailActivity();

}