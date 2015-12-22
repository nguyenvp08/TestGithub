package com.gotit.base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.gotit.R;

/**
 * Created by NguyenHN on 12/18/2015.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar mToolbar;
    protected RelativeLayout mLayoutToolbarContent;
    protected FloatingActionButton mFloatingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set base activity content
        setContentView(R.layout.base_activity);

        // set parent content;
        ViewGroup contentParent = (ViewGroup) findViewById(R.id.base_content);
        LayoutInflater.from(this).inflate(getlayoutId(), contentParent);

        mFloatingAction = (FloatingActionButton) findViewById(R.id.fab);
        mFloatingAction.setVisibility(View.GONE);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setVisibility(isShowAction() ? View.VISIBLE : View.GONE);

        initViews();
        onSetActionViews();
    }

    public abstract int getlayoutId();

    public abstract void initViews();

    public abstract void onSetActionViews();

    public abstract  boolean isShowAction();
}