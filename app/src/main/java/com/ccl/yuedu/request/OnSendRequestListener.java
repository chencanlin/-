package com.ccl.yuedu.request;

/**
 * Created by chencanlin on 2018/9/25 17:50
 */
public interface OnSendRequestListener {

    void onFailed(String message);

    void onSucceed(String response);
}
