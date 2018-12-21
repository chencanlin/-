package com.ccl.yuedu.listener;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

/**
 * Created by chencanlin on 2018/12/21 10:13
 */
public class BaseUiListener implements IUiListener {
    @Override
    public void onComplete(Object o) {
        System.out.println(o);
    }

    @Override
    public void onError(UiError uiError) {

    }

    @Override
    public void onCancel() {

    }
}
