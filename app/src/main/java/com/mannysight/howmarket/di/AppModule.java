package com.mannysight.howmarket.di;

import android.app.Application;
import android.content.Context;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wamuo on 8/27/2017.
 */


@Module
public class AppModule {

  @Provides
  @Singleton
  Context provideContext(Application application) {
    return application;
  }


  @Provides
  @Singleton
  public Gson provideGSON() {
    return new Gson();
  }

  @Provides
  @Singleton
  public FirebaseDatabase provideFirebaseDatabase() {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    firebaseDatabase.setPersistenceEnabled(true);
    return firebaseDatabase;
  }

  @Provides
  @Singleton
  public FirebaseAuth provideFirebaseAuth() {
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    return firebaseAuth;
  }


  @Provides
  @Singleton
  public SharedPreferences provideSharedPreferences(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context);
  }

}