package com.ccl.yuedu.ui.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.text.TextUtils;
import android.transition.Transition;
import android.view.View;

import com.blankj.utilcode.util.BarUtils;
import com.ccl.yuedu.R;
import com.ccl.yuedu.base.BaseAppCompatActivity;
import com.ccl.yuedu.constans.QQConstants;
import com.ccl.yuedu.message.CustomMessageInfo;
import com.ccl.yuedu.message.EventBusUtil;
import com.ccl.yuedu.message.MessageCode;
import com.ccl.yuedu.request.request.CommonService;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

/**
 * Created by chencanlin on 2018/12/21 10:23
 */
public class QQEntityActivity extends BaseAppCompatActivity {

    private Tencent mTencent;
    private View mLLMask;
    private View mLLQQIcon;
    private View mPB;
    private String mOperationType;
    private BaseUiListener mBaseUiListener;


    public static void start(Activity activity, View shareElement, String operationType) {
        Intent intent = new Intent(activity, QQEntityActivity.class);
        intent.putExtra(QQConstants.EXTRA_KEY_OPERATION_TYPE, operationType);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (shareElement != null) {
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, shareElement, shareElement.getTransitionName());
                activity.startActivity(intent, optionsCompat.toBundle());
                return;
            }
        }
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqentity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            BarUtils.setStatusBarAlpha(this, 170);
        }
        addTransitionAnimationListener();
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
                    init();
                }

                @Override
                public void onTransitionCancel(Transition transition) {
                    init();
                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });
        } else {
            init();
        }
    }

    private void init() {
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mOperationType = intent.getStringExtra(QQConstants.EXTRA_KEY_OPERATION_TYPE);
        }
        if (TextUtils.isEmpty(mOperationType)) {
            mOperationType = QQConstants.OPERATION_TYPE_LOGIN;
        }
        if (mOperationType.equalsIgnoreCase(QQConstants.OPERATION_TYPE_LOGIN)) {
            login();
        }
    }

    private void initView() {
        mLLMask = findViewById(R.id.ll_mask);
        mLLQQIcon = findViewById(R.id.ll_qq_icon);
        mPB = findViewById(R.id.pb);
    }

    public void login() {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mLLQQIcon, "alpha", 1, 0);
        alpha.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mLLQQIcon.setVisibility(View.GONE);
                mPB.setVisibility(View.VISIBLE);
                mTencent = Tencent.createInstance(QQConstants.APP_ID, QQEntityActivity.this.getApplicationContext());
                if (!mTencent.isSessionValid()) {
                    mBaseUiListener = new BaseUiListener();
                    mTencent.login(QQEntityActivity.this, "all", mBaseUiListener);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        alpha.setDuration(500);
        alpha.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Tencent.onActivityResultData(requestCode, resultCode, data, mBaseUiListener);
    }

    public void getUserInfoInThread(Object o) {
        try {
            JSONObject jsonObject = (JSONObject) o;
            String access_token = jsonObject.optString("access_token");
            String openid = jsonObject.optString("openid");
            CommonService.getQQUserInfo(QQConstants.APP_ID, access_token, openid, "json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*new Thread() {
            @Override
            public void run() {
                JSONObject json = null;
                try {
                    json = mTencent.request(Constants.LOGIN_INFO, null,
                            Constants.HTTP_GET);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (HttpUtils.NetworkUnavailableException e) {
                    e.printStackTrace();
                } catch (HttpUtils.HttpStatusException e) {
                    e.printStackTrace();
                }
                System.out.println(json);
            }
        }.start();*/
    }

    private void showMask(boolean flag) {
        if (mLLMask == null) {
            mLLMask = findViewById(R.id.ll_mask);
        }
        mLLMask.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    public class BaseUiListener implements IUiListener {
        @Override
        public void onComplete(Object o) {
            getUserInfoInThread(o);
        }

        @Override
        public void onError(UiError uiError) {
            finish();
        }

        @Override
        public void onCancel() {
            finish();
        }
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected void onNotifyMainThread(final CustomMessageInfo customMessageInfo) {
        switch (customMessageInfo.getMessageCode()) {
            case MessageCode.GET_QQ_USER_INFO_SUCCEED:
                finish();
                getWindow().getDecorView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        EventBusUtil.sendEvent(MessageCode.LOGIN_SUCCEED, customMessageInfo.getData());
                    }
                }, 250);
                break;
        }
    }
}
