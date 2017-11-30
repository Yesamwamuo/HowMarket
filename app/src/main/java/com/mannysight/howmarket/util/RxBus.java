package com.mannysight.howmarket.util;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxBus {

  private RxBus() {
  }

  private static class SingletonHolder {

    private static final RxBus INSTANCE = new RxBus();
  }

  public static RxBus getBus() {
    return RxBus.SingletonHolder.INSTANCE;
  }

  private PublishSubject<Object> bus = PublishSubject.create();

  public void send(Object o) {
    bus.onNext(o);
  }

  public Observable<Object> toObserverable() {
    return bus;
  }

  public boolean hasObservers() {
    return bus.hasObservers();
  }
}
//
//public class Events {
//
//    private Events() {
//    }
//
//    public static class ReloadEvent {
//        public boolean mForceUpdate;
//
//        public ReloadEvent(boolean forceUpdate) {
//            mForceUpdate = forceUpdate;
//        }
//    }
//
//}
//
//    private CompositeDisposable mCompositeDisposable;
//
//    @Override
//    public void subscribe() {
//        initRxBus();
//    }
//
//    private void initRxBus() {
//        mCompositeDisposable.add(RxBus.getBus()
//                .toObserverable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(o -> {
//                    if (o instanceof Events.ReloadEvent) {
//                        loadBooks(((Events.ReloadEvent) o).mForceUpdate);
//                    }
//                }));
//    }
//
//    @Override
//    public void unSubscribe() {
//        mCompositeDisposable.clear();
//    }
//
//
//    RxBus.getBus().send(new Events.ReloadEvent(false));