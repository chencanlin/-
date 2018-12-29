package com.ccl.yuedu;

import android.support.multidex.MultiDexApplication;

import com.ccl.yuedu.message.EventBusUtil;

/**
 * Created by chencanlin on 2018/12/18 17:09
 */
public class YDApplication extends MultiDexApplication {
    private static YDApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initEventBus();
    }

    private void initEventBus() {
        EventBusUtil.init();
    }

    public static YDApplication getInstance() {
        return instance;
    }
}
