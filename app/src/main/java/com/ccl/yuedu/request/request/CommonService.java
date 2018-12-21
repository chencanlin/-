package com.ccl.yuedu.request.request;

import com.ccl.yuedu.bean.PeronalInfo;
import com.ccl.yuedu.message.EventBusUtil;
import com.ccl.yuedu.message.MessageCode;
import com.ccl.yuedu.request.OnSendRequestListener;
import com.ccl.yuedu.request.util.HttpUtil;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by chencanlin on 2018/9/25 17:42
 */
public class CommonService {

    public static void getQQUserInfo(String appId, String accessToken, String openId, String format) {
        CommonServiceApi commonServiceApi = HttpUtil.createApi(CommonServiceApi.class);
        Call<ResponseBody> responseBodyCall = commonServiceApi.testRequest(appId, accessToken, openId, format);
        HttpUtil.sendRequest(responseBodyCall, new OnSendRequestListener() {
            @Override
            public void onFailed(String message) {
                EventBusUtil.sendEvent(MessageCode.GET_QQ_USER_INFO_FAILED, null, message);
            }

            @Override
            public void onSucceed(String response) {
                PeronalInfo peronalInfo = ResponseParser.parsePersonalInfo(response);
                EventBusUtil.sendEvent(MessageCode.GET_QQ_USER_INFO_SUCCEED, peronalInfo);
            }
        });
    }
}
