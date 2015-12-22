package com.gotit.activity;

import android.content.Intent;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.gotit.R;
import com.gotit.base.BaseActivity;

/**
 * Created by NguyenHN on 12/20/2015.
 */
public class LoginActivity extends BaseActivity {

    private LoginButton mLoginButton;
    private CallbackManager mCallbackManager;

    @Override
    public int getlayoutId() {
        return R.layout.layout_login;
    }

    @Override
    public void initViews() {
        mLoginButton = (LoginButton) findViewById(R.id.fb_login_button);
        mLoginButton.setReadPermissions("public_profile");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSetActionViews() {
        mCallbackManager = CallbackManager.Factory.create();
        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {
            }
        });
    }

    @Override
    public boolean isShowAction() {
        return false;
    }
}
