package com.ccl.yuedu.message;

/**
 * Created by ccl on 2018/1/22.
 */

public interface MessageCode {

    int GET_QQ_USER_INFO_SUCCEED = 0;
    int GET_QQ_USER_INFO_FAILED = 1;
    int LOGIN_SUCCEED = 2;

    int GET_BOOK_ALL_CATEGORY_SUCCEED = 3;
    int GET_BOOK_ALL_CATEGORY_FAILED = 4;

    int GET_BOOK_LIST_BY_CATEGORY_SUCCEED = 5;
    int GET_BOOK_LIST_BY_CATEGORY_FAILED = 6;

    int GET_BOOK_DETAIL_SUCCEED = 7;
    int GET_BOOK_DETAIL_FAILED = 8;
}
