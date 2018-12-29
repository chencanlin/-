package com.ccl.yuedu.bean;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

/**
 * Created by chencanlin on 2018/12/24 17:20
 */
@Data
public class BookCategoryBean {
    @JSONField
    public String name;
    @JSONField
    public String bookCount;
    @JSONField
    public String monthlyCount;
    @JSONField
    public String icon;
    @JSONField
    public String bookCover;
}
