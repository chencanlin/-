package com.ccl.yuedu;

import android.app.Application;

import com.ccl.yuedu.message.EventBusUtil;

/**
 * Created by chencanlin on 2018/12/18 17:09
 */
public class YDApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initEventBus();
    }

    private void initEventBus() {
        EventBusUtil.init();
    }
}
