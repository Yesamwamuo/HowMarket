package com.mannysight.howmarket.createaccount;

import android.support.annotation.StringRes;
import com.mannysight.howmarket.BasePresenter;
import com.mannysight.howmarket.BaseView;

/**
 * Created by wamuo on 10/15/2017.
 */

public interface CreateAccountContract {

  interface View extends BaseView<Presenter> {
    void makeToast(@StringRes int stringId);

    String getEmail();

    String getName();

    void startLoginActivity();

    void startMainActivity();

    void showProgressIndicator(boolean show);
  }

  interface Presenter extends BasePresenter {
    void onCreateAccountClick();

  }

}
