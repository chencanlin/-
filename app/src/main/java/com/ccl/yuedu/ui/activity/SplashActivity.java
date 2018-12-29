package com.ccl.yuedu.ui.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.util.BarUtils;
import com.ccl.yuedu.R;
import com.ccl.yuedu.base.BaseAppCompatActivity;

/**
 * Created by chencanlin on 2018/12/18 17:13
 */
public class SplashActivity extends BaseAppCompatActivity {
    private static SplashActivity instance;

    private ImageView mIvMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        instance = this;
        BarUtils.setStatusBarColor(this, getResources().getColor(R.color.colorPrimaryDark), 36);
        init();
    }

    private void init() {
        initView();

    }

    private void initView() {
        mIvMain = findViewById(R.id.iv_main);
        mIvMain.postDelayed(new Runnable() {
            @Override
            public void run() {
                mIvMain.setVisibility(View.VISIBLE);
                ObjectAnimator alpha = ObjectAnimator.ofFloat(mIvMain, "alpha", 0, 1);
                alpha.addListener(new MyAnimatorListener());
                alpha.setDuration(1000);
                alpha.start();
            }
        }, 500);
    }

    private class MyAnimatorListener implements Animator.AnimatorListener {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(SplashActivity.this, mIvMain, mIvMain.getTransitionName());
                startActivity(new Intent(SplashActivity.this, LoginActivity.class), optionsCompat.toBundle());
            } else {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    }

    public static void finishMySelf() {
        if (instance != null) {
            instance.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (instance != null) {
            instance = null;
        }
    }
}
