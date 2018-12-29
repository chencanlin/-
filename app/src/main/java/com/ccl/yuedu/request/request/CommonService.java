package com.ccl.yuedu.request.request;

import com.ccl.yuedu.bean.BookCategoryBean;
import com.ccl.yuedu.bean.BookInfoBean;
import com.ccl.yuedu.bean.PeronalInfo;
import com.ccl.yuedu.constans.Domain;
import com.ccl.yuedu.message.EventBusUtil;
import com.ccl.yuedu.message.MessageCode;
import com.ccl.yuedu.request.OnSendRequestListener;
import com.ccl.yuedu.request.util.HttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by chencanlin on 2018/9/25 17:42
 */
public class CommonService {

    public static void getQQUserInfo(String appId, String accessToken, String openId, String format) {
        CommonServiceApi commonServiceApi = HttpUtil.createApi(CommonServiceApi.class, Domain.DOMAIN_TENCENT_QQ_LOGIN_GET_INGO);
        Call<ResponseBody> responseBodyCall = commonServiceApi.qqLoginGetUserInfo(appId, accessToken, openId, format);
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

    public static void getBookAllCategory(final int hashCode) {
        CommonServiceApi api = HttpUtil.createApi(CommonServiceApi.class, Domain.DOMAIN_ZHUISHUSHENQI);
        Call<ResponseBody> bookAllCategory = api.getBookAllCategory();
        HttpUtil.sendRequest(bookAllCategory, new OnSendRequestListener() {
            @Override
            public void onFailed(String message) {
                EventBusUtil.sendEvent(hashCode, MessageCode.GET_BOOK_ALL_CATEGORY_FAILED, null, message);
            }

            @Override
            public void onSucceed(String response) {
                boolean requestSucceed = ResponseParser.isRequestSucceed(response);
                if (requestSucceed) {
                    Map<String, List<BookCategoryBean>> allBookCategoryMap = ResponseParser.parseAllBookCategory(response);
                    EventBusUtil.sendEvent(hashCode, MessageCode.GET_BOOK_ALL_CATEGORY_SUCCEED, allBookCategoryMap);
                } else {
                    EventBusUtil.sendEvent(hashCode, MessageCode.GET_BOOK_ALL_CATEGORY_FAILED);
                }
            }
        });
    }

    public static void getBookListByCategory(String gender, String type, String major, int start, int limit) {
        CommonServiceApi api = HttpUtil.createApi(CommonServiceApi.class, Domain.DOMAIN_ZHUISHUSHENQI);
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("gender", gender);
        paramsMap.put("type", type);
        paramsMap.put("major", major);
        paramsMap.put("start", String.valueOf(start));
        paramsMap.put("limit", String.valueOf(limit));
        Call<ResponseBody> bookListByCategory = api.getBookListByCategory(paramsMap);
        HttpUtil.sendRequest(bookListByCategory, new OnSendRequestListener() {
            @Override
            public void onFailed(String message) {
                EventBusUtil.sendEvent(MessageCode.GET_BOOK_LIST_BY_CATEGORY_FAILED, null, message);
            }

            @Override
            public void onSucceed(String response) {
                boolean requestSucceed = ResponseParser.isRequestSucceed(response);
                if (requestSucceed) {
                    List<BookInfoBean> bookInfoBeanList = ResponseParser.parseBookList(response);
                    EventBusUtil.sendEvent(MessageCode.GET_BOOK_LIST_BY_CATEGORY_SUCCEED, bookInfoBeanList);
                } else {
                    EventBusUtil.sendEvent(MessageCode.GET_BOOK_LIST_BY_CATEGORY_FAILED);
                }
            }
        });
    }
}
