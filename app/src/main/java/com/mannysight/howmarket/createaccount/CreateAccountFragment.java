package com.mannysight.howmarket.createaccount;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.googlejavaformat.java.Main;
import com.mannysight.howmarket.MainActivity;
import com.mannysight.howmarket.R;
import com.mannysight.howmarket.login.LoginActivity;
import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateAccountFragment extends Fragment implements CreateAccountContract.View {


  @Inject
  CreateAccountContract.Presenter mPresenter;

  @BindView(R.id.activity_register_userName)
  EditText emailInput;
  @BindView(R.id.activity_register_userEmail)
  EditText nameInput;


  public CreateAccountFragment() {
    // Required empty public constructor
  }

  @Override
  public void onResume() {
    super.onResume();
    mPresenter.takeView(this);
  }

  @Override
  public void onDestroy() {
    mPresenter.dropView();
    super.onDestroy();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_create_account, container, false);
    ButterKnife.bind(this, rootView);
    return rootView;
  }

  @Override
  public void makeToast(@StringRes int stringId) {
    Toast.makeText(getActivity().getApplicationContext(), getString(stringId), Toast.LENGTH_SHORT)
        .show();
  }


  @Override
  public String getEmail() {
    return emailInput.getText().toString();
  }


  @Override
  public String getName() {
    return nameInput.getText().toString();
  }

  @Override
  public void startLoginActivity() {
    Intent i = new Intent(getActivity(), LoginActivity.class);
    startActivity(i);
  }

  @Override
  public void startMainActivity() {
    Intent i = new Intent(getActivity(), MainActivity.class);
    startActivity(i);
  }

  @Override
  public void showProgressIndicator(boolean show) {
//    if (show) {
//      progressBar.setVisibility(View.VISIBLE);
//      contentContainer.setVisibility(View.INVISIBLE);
//    } else {
//      progressBar.setVisibility(View.INVISIBLE);
//      contentContainer.setVisibility(View.VISIBLE);
//    }
  }
}
