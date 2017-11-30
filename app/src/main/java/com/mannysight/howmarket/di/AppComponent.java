package com.mannysight.howmarket.di;

import android.app.Application;

import com.mannysight.howmarket.HowMarket;
import com.mannysight.howmarket.data.RepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by wamuo on 8/27/2017.
 */

@Singleton
@Component(modules = {RepositoryModule.class,
    ModuleBuilder.class,
    AppModule.class,
    AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

  void inject(HowMarket app);

  @Override
  void inject(DaggerApplication instance);

  @Component.Builder
  interface Builder {

    @BindsInstance
    AppComponent.Builder application(Application application);

    AppComponent build();
  }

}
