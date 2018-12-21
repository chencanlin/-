package com.ccl.yuedu.request.request;

import android.text.TextUtils;

import com.ccl.yuedu.bean.PeronalInfo;

import org.json.JSONObject;

/**
 * Created by chencanlin on 2018/12/21 17:59
 */
public class ResponseParser {

    public static PeronalInfo parsePersonalInfo(String result) {
        PeronalInfo peronalInfo = new PeronalInfo();
        try {
            JSONObject jsonObject = new JSONObject(result);
            String nickname = jsonObject.optString("nickname");
            String avatar = jsonObject.optString("figureurl_qq_2");
            if (TextUtils.isEmpty(avatar)) {
                avatar = jsonObject.optString("figureurl_qq_1");
            }
            peronalInfo.name = nickname;
            peronalInfo.avatarUrl = avatar;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peronalInfo;
    }
}
