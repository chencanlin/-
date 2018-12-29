package com.ccl.yuedu.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by chencanlin on 2018/12/29 16:33
 */
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
//    @JSONField
//    public String
}
