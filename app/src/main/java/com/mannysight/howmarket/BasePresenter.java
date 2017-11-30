package com.mannysight.howmarket;

/**
 * Created by wamuo on 8/28/2017.
 */


public interface BasePresenter<T> {

  void takeView(T view);

  void dropView();

}
