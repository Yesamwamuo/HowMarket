package com.mannysight.howmarket.util;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wamuo on 9/2/2017.
 */

public class ImmediateSchedulerProvider implements BaseSchedulerProvider {

  @Override
  public Scheduler computation() {
    return Schedulers.trampoline();
  }

  @Override
  public Scheduler ui() {
    return Schedulers.trampoline();
  }

  @Override
  public Scheduler io() {
    return Schedulers.trampoline();
  }
}
