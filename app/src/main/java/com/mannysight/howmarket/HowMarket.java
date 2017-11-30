package com.mannysight.howmarket;

import android.app.Activity;
import android.app.Application;


import com.mannysight.howmarket.di.AppComponent;
import com.mannysight.howmarket.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by wamuo on 8/27/2017.
 */

public class HowMarket extends DaggerApplication {

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
    appComponent.inject(this);
    return appComponent;
  }

}
