package com.ccl.yuedu.bean;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

/**
 * Created by chencanlin on 2019/1/2 10:32
 */
@Data
public class BookDetailRatingInfoBean {
    @JSONField
    public String count;
    @JSONField
    public String score;
}
