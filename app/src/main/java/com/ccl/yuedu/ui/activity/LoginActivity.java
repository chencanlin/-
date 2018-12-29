package com.ccl.yuedu.ui.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Transition;
import android.view.View;

import com.ccl.yuedu.R;
import com.ccl.yuedu.base.BaseAppCompatActivity;
import com.ccl.yuedu.bean.PeronalInfo;
import com.ccl.yuedu.constans.CommonExtraKey;
import com.ccl.yuedu.constans.QQConstants;
import com.ccl.yuedu.message.CustomMessageInfo;
import com.ccl.yuedu.message.MessageCode;


/**
 * Created by chencanlin on 2018/12/19 13:54
 */
public class LoginActivity extends BaseAppCompatActivity implements View.OnClickListener {

    private View mIvBgWall;
    private View mTvSubtitle;
    private View mIvLoginType;
    private View mLlLoginType;
    private View mIvLoginQq;
    private View mIvLoginQqPlaceholder;
    private View mIvLoginWechat;
    private View mIvLoginWeibo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mIvLoginQqPlaceholder != null) {
            mIvLoginQqPlaceholder.setVisibility(View.GONE);
        }
    }

    private void addTransitionAnimationListener() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition sharedElementEnterTransition = getWindow().getSharedElementEnterTransition();
            sharedElementEnterTransition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {

                }

                @Override
                public void onTransitionEnd(Transition transition) {
                    setViewVisible();
                    setViewAlphaAnimation();
                    SplashActivity.finishMySelf();
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });
        } else {
            setViewVisible();
        }
    }

    private void setViewAlphaAnimation() {
        generateAlphaAnimator(mIvBgWall);
        generateAlphaAnimator(mTvSubtitle);
        generateAlphaAnimator(mIvLoginType);
        generateAlphaAnimator(mLlLoginType);
    }

    private void generateAlphaAnimator(View view) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 0, 1);
        alpha.setDuration(1000);
        alpha.start();
    }

    private void setViewVisible() {
        mIvBgWall.setVisibility(View.VISIBLE);
        mTvSubtitle.setVisibility(View.VISIBLE);
        mIvLoginType.setVisibility(View.VISIBLE);
        mLlLoginType.setVisibility(View.VISIBLE);
    }

    private void init() {
        initView();
        setView();
    }

    private void setView() {

    }

    private void initView() {
        mIvBgWall = findViewById(R.id.iv_bg_wall);
        mTvSubtitle = findViewById(R.id.tv_subtitle);
        mIvLoginType = findViewById(R.id.iv_login_type);
        mLlLoginType = findViewById(R.id.ll_login_type);
        mIvLoginQq = findViewById(R.id.iv_login_qq);
        mIvLoginQqPlaceholder = findViewById(R.id.iv_qq_placeholder);
        mIvLoginWechat = findViewById(R.id.iv_login_wechat);
        mIvLoginWeibo = findViewById(R.id.iv_login_weibo);
        addTransitionAnimationListener();

        setViewListener();
    }

    private void setViewListener() {
        mIvLoginQq.setOnClickListener(this);
        mIvLoginWechat.setOnClickListener(this);
        mIvLoginWeibo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_login_qq:
                QQEntityActivity.start(LoginActivity.this, mIvLoginQq, QQConstants.OPERATION_TYPE_LOGIN);
                mIvLoginQqPlaceholder.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_login_wechat:
                startMainActivity(null);
                break;
            case R.id.iv_login_weibo:
                startMainActivity(null);
                break;
        }
    }

    private void startMainActivity(PeronalInfo peronalInfo) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(CommonExtraKey.EXTRA_KEY_PERSONAL_INFO, peronalInfo);
        startActivity(intent);
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected void onNotifyMainThread(CustomMessageInfo customMessageInfo) {
        switch (customMessageInfo.getMessageCode()) {
            case MessageCode.LOGIN_SUCCEED:
                PeronalInfo peronalInfo = (PeronalInfo) customMessageInfo.getData();
                startMainActivity(peronalInfo);
                finish();
                break;
        }
    }
}
