package com.ccl.yuedu.request.util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by chencanlin on 2018/10/8 13:59
 */
public class ResponseParseUtil {

    public static final String RETURN_CODE_SUCCEED_ZERO = "0";
    public static final String RETURN_CODE_SUCCEED_ONE = "-1";

    public static boolean isRequestSucceed(String body) {
        if (body != null && body.trim().length() != 0) {
            try {
                JSONObject jsonObject = new JSONObject(body);
                String code = jsonObject.optString("return_code");
                if (RETURN_CODE_SUCCEED_ZERO.equalsIgnoreCase(code) || RETURN_CODE_SUCCEED_ONE.equalsIgnoreCase(code)) {
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static int parseMessageId(String body) {
        if (body != null && body.trim().length() != 0) {
            try {
                JSONObject jsonObject = new JSONObject(body);
                JSONObject dataObj = jsonObject.optJSONObject("data");
                if (dataObj != null) {
                    return dataObj.optInt("messageId", -1000);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return -1000;
    }
}
