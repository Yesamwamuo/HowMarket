package com.mannysight.howmarket.util;

import io.reactivex.Scheduler;

/**
 * Created by wamuo on 9/1/2017.
 */

public interface BaseSchedulerProvider {

  Scheduler computation();

  Scheduler ui();

  Scheduler io();

}
