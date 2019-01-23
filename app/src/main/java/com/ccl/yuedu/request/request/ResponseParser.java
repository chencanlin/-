package com.ccl.yuedu.request.request;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ccl.yuedu.bean.BookCategoryBean;
import com.ccl.yuedu.bean.BookCategoryInfoBean;
import com.ccl.yuedu.bean.BookDetailInfoBean;
import com.ccl.yuedu.bean.PeronalInfo;
import com.ccl.yuedu.constans.BookCategoryConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chencanlin on 2018/12/21 17:59
 */
public class ResponseParser {

    public static boolean isRequestSucceed(String result) {
        boolean isOk = false;
        try {
            JSONObject jsonObject = new JSONObject(result);
            isOk = jsonObject.optBoolean("ok");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return isOk;
    }

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

    public static Map<String, List<BookCategoryBean>> parseAllBookCategory(String result) {
        Map<String, List<BookCategoryBean>> allBookCategoryMap = new HashMap<>();
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(result);
        allBookCategoryMap.put(BookCategoryConstants.MALE, JSONArray.parseArray(jsonObject.getString(BookCategoryConstants.MALE), BookCategoryBean.class));
        allBookCategoryMap.put(BookCategoryConstants.FEMALE, JSONArray.parseArray(jsonObject.getString(BookCategoryConstants.FEMALE), BookCategoryBean.class));
        allBookCategoryMap.put(BookCategoryConstants.PICTURE, JSONArray.parseArray(jsonObject.getString(BookCategoryConstants.PICTURE), BookCategoryBean.class));
        allBookCategoryMap.put(BookCategoryConstants.PRESS, JSONArray.parseArray(jsonObject.getString(BookCategoryConstants.PRESS), BookCategoryBean.class));
        return allBookCategoryMap;
    }

    public static List<BookCategoryInfoBean> parseBookList(String result) {
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(result);
        return JSONArray.parseArray(jsonObject.getString("books"), BookCategoryInfoBean.class);
    }

    public static BookDetailInfoBean parseBookDetail(String result) {
        return JSONArray.parseObject(result, BookDetailInfoBean.class);
    }
}
