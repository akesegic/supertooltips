package com.haarman.supertooltips;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener, ToolTipView.OnToolTipViewClickedListener {

    private ToolTipView mRedToolTipView;
    private ToolTipView mGreenToolTipView;
    private ToolTipView mBlueToolTipView;
    private ToolTipView mPurpleToolTipView;
    private ToolTipView mOrangeToolTipView;
    private ToolTipRelativeLayout mToolTipFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolTipFrameLayout = (ToolTipRelativeLayout) findViewById(R.id.activity_main_tooltipframelayout);
        findViewById(R.id.activity_main_redtv).setOnClickListener(MainActivity.this);
        findViewById(R.id.activity_main_greentv).setOnClickListener(MainActivity.this);
        findViewById(R.id.activity_main_bluetv).setOnClickListener(MainActivity.this);
        findViewById(R.id.activity_main_purpletv).setOnClickListener(MainActivity.this);
        findViewById(R.id.activity_main_orangetv).setOnClickListener(MainActivity.this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addRedToolTipView();
            }
        }, 500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addGreenToolTipView();
            }
        }, 700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addOrangeToolTipView();
            }
        }, 900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addBlueToolTipView();
            }
        }, 1100);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addPurpleToolTipView();
            }
        }, 1300);

    }

    private void addRedToolTipView() {
        mRedToolTipView = mToolTipFrameLayout.showToolTipForView(
                new ToolTip()
                        .withText("A beautiful Button")
                        .withColor(getResources().getColor(R.color.holo_red))
                        .withShadow(true),
                findViewById(R.id.activity_main_redtv));
        mRedToolTipView.setOnToolTipViewClickedListener(MainActivity.this);
    }

    private void addGreenToolTipView() {
        mGreenToolTipView = mToolTipFrameLayout.showToolTipForView(
                new ToolTip()
                        .withText("Another beautiful Button!")
                        .withColor(getResources().getColor(R.color.holo_green)),
                findViewById(R.id.activity_main_greentv));
        mGreenToolTipView.setOnToolTipViewClickedListener(MainActivity.this);
    }

    private void addBlueToolTipView() {
        mBlueToolTipView = mToolTipFrameLayout.showToolTipForView(
                new ToolTip()
                        .withText("Moarrrr buttons!")
                        .withColor(getResources().getColor(R.color.holo_blue))
                        .withAnimationType(ToolTip.ANIMATIONTYPE_FROMTOP),
                findViewById(R.id.activity_main_bluetv));
        mBlueToolTipView.setOnToolTipViewClickedListener(MainActivity.this);
    }

    private void addPurpleToolTipView() {
        mPurpleToolTipView = mToolTipFrameLayout.showToolTipForView(
                new ToolTip()
                        .withContentView(LayoutInflater.from(this).inflate(R.layout.custom_tooltip, null))
                        .withColor(getResources().getColor(R.color.holo_purple)),
                findViewById(R.id.activity_main_purpletv));
        mPurpleToolTipView.setOnToolTipViewClickedListener(MainActivity.this);
    }

    private void addOrangeToolTipView() {
        mOrangeToolTipView = mToolTipFrameLayout.showToolTipForView(
                new ToolTip()
                        .withText("Tap me!")
                        .withColor(getResources().getColor(R.color.holo_orange)),
                findViewById(R.id.activity_main_orangetv));
        mOrangeToolTipView.setOnToolTipViewClickedListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.activity_main_redtv) {
            if (mRedToolTipView == null) {
                addRedToolTipView();
            } else {
                mRedToolTipView.remove();
                mRedToolTipView = null;
            }
        }
        if (view.getId() == R.id.activity_main_greentv) {
            if (mGreenToolTipView == null) {
                addGreenToolTipView();
            } else {
                mGreenToolTipView.remove();
                mGreenToolTipView = null;
            }
        }
        if (view.getId() == R.id.activity_main_bluetv) {
            if (mBlueToolTipView == null) {
                addBlueToolTipView();
            } else {
                mBlueToolTipView.remove();
                mBlueToolTipView = null;
            }
        }
        if (view.getId() == R.id.activity_main_purpletv) {
            if (mPurpleToolTipView == null) {
                addPurpleToolTipView();
            } else {
                mPurpleToolTipView.remove();
                mPurpleToolTipView = null;
            }
        }
        if (view.getId() == R.id.activity_main_orangetv) {
            if (mOrangeToolTipView == null) {
                addOrangeToolTipView();
            } else {
                mOrangeToolTipView.remove();
                mOrangeToolTipView = null;
            }
        }
    }

    @Override
    public void onToolTipViewClicked(ToolTipView toolTipView) {
        if (mRedToolTipView == toolTipView) {
            mRedToolTipView = null;
        } else if (mGreenToolTipView == toolTipView) {
            mGreenToolTipView = null;
        } else if (mBlueToolTipView == toolTipView) {
            mBlueToolTipView = null;
        } else if (mPurpleToolTipView == toolTipView) {
            mPurpleToolTipView = null;
        } else if (mOrangeToolTipView == toolTipView) {
            mOrangeToolTipView = null;
        }
    }
}

