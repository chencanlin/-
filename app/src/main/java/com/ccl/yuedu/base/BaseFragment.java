package com.ccl.yuedu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.ccl.yuedu.message.CustomMessageInfo;
import com.ccl.yuedu.message.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by chencanlin on 2018/12/24 15:35
 */
public class BaseFragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isRegisterEventBus()) {
            EventBusUtil.register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRegisterEventBus()) {
            EventBusUtil.unRegister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMsgMainThread(CustomMessageInfo customMessageInfo) {
        onNotifyMainThread(customMessageInfo);
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
        onNotifyStickyMsgMainThread(customMessageInfo);
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
}
