package com.gotit.activity;

import android.content.Intent;
import android.view.View;

import com.facebook.appevents.AppEventsLogger;
import com.gotit.R;
import com.gotit.base.BaseActivity;

import java.util.logging.Handler;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    public int getlayoutId() {
        return R.layout.layout_splash;
    }

    @Override
    public void initViews() {
        mToolbar.setVisibility(View.GONE);

        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                overridePendingTransition(0, 0);
            }
        }, 2000);
    }

    @Override
    public void onSetActionViews() {
    }

    @Override
    public boolean isShowAction() {
        return false;
    }
}
