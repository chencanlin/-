package com.ccl.yuedu.bean;

import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import lombok.Data;

/**
 * Created by chencanlin on 2018/12/29 16:33
 */
@Data
public class BookDetailInfoBean {

    @JSONField(name = "_id")
    public String id;
    @JSONField
    public String title;
    @JSONField
    public String author;
    @JSONField
    public String longIntro;
    @JSONField
    public String cover;
    @JSONField
    public String majorCate;
    @JSONField
    public String minorCate;
    @JSONField
    public String retentionRatio;
    @JSONField(name = "rating")
    public BookDetailRatingInfoBean mBookDetailRatingInfoBean;
    @JSONField
    public String latelyFollower;
    @JSONField
    public String wordCount;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        if (!TextUtils.isEmpty(cover) && cover.contains("/agent/")) {
            String[] split = cover.split("/agent/");
            if (split.length > 1) {
                cover = split[1];
                try {
                    cover = URLDecoder.decode(cover, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        this.cover = cover;
    }
}
