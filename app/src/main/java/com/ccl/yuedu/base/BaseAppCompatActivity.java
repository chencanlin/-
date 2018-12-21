package com.ccl.yuedu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.ccl.yuedu.message.CustomMessageInfo;
import com.ccl.yuedu.message.EventBusUtil;
import com.ccl.yuedu.ui.widget.LoadingDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by chencanlin on 2018/12/18 17:18
 */
public class BaseAppCompatActivity extends AppCompatActivity implements LoadingDialog.OnKeyDownListener {

    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isRegisterEventBus()) {
            EventBusUtil.unRegister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsgMainThread(CustomMessageInfo customMessageInfo) {
        if (customMessageInfo != null) {
            onNotifyMainThread(customMessageInfo);
        }
    }

    /**
     * 重写此方法在主线程接收事件
     *
     * @param customMessageInfo 接收的事件
     * @author ccl
     * @date 2018/1/23 16:21
     */
    protected void onNotifyMainThread(CustomMessageInfo customMessageInfo) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReceiveStickyMsgMainThread(CustomMessageInfo customMessageInfo) {
        if (customMessageInfo != null) {
            onNotifyStickyMsgMainThread(customMessageInfo);
        }
    }

    /**
     * 重写此方法在主线程接收粘性事件
     *
     * @param customMessageInfo 接收的事件
     * @author ccl
     * @date 2018/1/23 16:19
     */
    protected void onNotifyStickyMsgMainThread(CustomMessageInfo customMessageInfo) {

    }

    /**
     * 是否需要注册事件监听
     *
     * @author ccl
     * @date 2018/1/23 11:38
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    public void showLoading() {
        if (mLoadingDialog == null) {
            mLoadingDialog = LoadingDialog.showLoadingDialog(this, this);
        } else {
            mLoadingDialog.setMessage("");
            mLoadingDialog.setOnKeyDownListener(this);
            mLoadingDialog.show();
        }
    }

    public void showLoading(int strId) {
        if (mLoadingDialog == null) {
            mLoadingDialog = LoadingDialog.showLoadingDialog(this, strId, this);
        } else {
            mLoadingDialog.setMessage(strId);
            mLoadingDialog.setOnKeyDownListener(this);
            mLoadingDialog.show();
        }
    }

    public void showLoading(String text) {
        if (mLoadingDialog == null) {
            mLoadingDialog = LoadingDialog.showLoadingDialog(this, text, this);
        } else {
            mLoadingDialog.setMessage(text);
            mLoadingDialog.setOnKeyDownListener(this);
            mLoadingDialog.show();
        }
    }

    public void dismissLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void onLoadingDialogKeyDown(int keyCode, KeyEvent event) {
        onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
