package com.mannysight.howmarket.data.auth;

import io.reactivex.Completable;
import io.reactivex.Maybe;

/**
 * Created by wamuo on 9/1/2017.
 */

public class FakeAuthService implements AuthSource {

  @Override
  public Completable createAccount(Credentials cred) {
    return null;
  }

  @Override
  public Completable attemptLogin(Credentials cred) {
    return null;
  }

  @Override
  public Completable deleteUser() {
    return null;
  }

  @Override
  public Maybe<User> getUser() {
    return null;
  }

  @Override
  public Completable logUserOut() {
    return null;
  }

  @Override
  public Completable reauthenticateUser(String password) {
    return null;
  }

  @Override
  public void setReturnFail(boolean bool) {

  }
}
