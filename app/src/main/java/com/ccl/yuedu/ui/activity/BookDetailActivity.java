package com.ccl.yuedu.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ccl.yuedu.R;
import com.ccl.yuedu.base.BaseAppCompatActivity;
import com.ccl.yuedu.bean.BookCategoryInfoBean;
import com.ccl.yuedu.constans.CommonExtraKey;
import com.ccl.yuedu.request.request.CommonService;

import butterknife.ButterKnife;

public class BookDetailActivity extends BaseAppCompatActivity {

    private BookCategoryInfoBean mBookCategoryInfoBean;

    public static void start(Activity activity, BookCategoryInfoBean bookCategoryInfoBean) {
        Intent intent = new Intent(activity, BookDetailActivity.class);
        intent.putExtra(CommonExtraKey.EXTRA_KEY_BOOK_CATEGORY_INFO_BEAN, bookCategoryInfoBean);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mBookCategoryInfoBean = intent.getParcelableExtra(CommonExtraKey.EXTRA_KEY_BOOK_CATEGORY_INFO_BEAN);
        }
        requestBookDetail();
    }

    private void initView() {

    }

    private void requestBookDetail() {
        if (mBookCategoryInfoBean != null) {
            showLoading();
            CommonService.getBookDetail(mBookCategoryInfoBean.getId());
        }
    }
}
