package com.mannysight.howmarket.data;

import com.mannysight.howmarket.data.auth.AuthSource;
import com.mannysight.howmarket.data.auth.FirebaseAuthService;
import com.mannysight.howmarket.util.BaseSchedulerProvider;
import com.mannysight.howmarket.util.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wamuo on 9/1/2017.
 */

@Module

public class RepositoryModule {


  @Singleton
  @Provides
  AuthSource provideAuthSource() {
    return new FirebaseAuthService();
  }

  @Singleton
  @Provides
  BaseSchedulerProvider baseSchedulerProvider() {
    return new SchedulerProvider();
  }

}
