package com.ccl.yuedu.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.ccl.yuedu.R;
import com.ccl.yuedu.bean.BookCategoryBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by chencanlin on 2018/12/24 17:57
 */
public class BookCategoryRVAdapter extends BaseQuickAdapter<BookCategoryBean, BookCategoryRVAdapter.BookCategoryViewHolder> {

    private final String mType;

    public String getType() {
        return mType;
    }

    public BookCategoryRVAdapter(@Nullable List<BookCategoryBean> data, String type) {
        super(R.layout.layout_book_category_rv_item, data);
        mType = type;
    }

    @Override
    protected void convert(BookCategoryViewHolder helper, BookCategoryBean item) {
        helper.setText(R.id.tv_category_name, item.getName());
        helper.setText(R.id.tv_book_count, item.getBookCount());
    }

    public static class BookCategoryViewHolder extends BaseViewHolder {
        public BookCategoryViewHolder(View view) {
            super(view);
            View itemRoot = view.findViewById(R.id.item_root);
            ViewGroup.LayoutParams layoutParams = itemRoot.getLayoutParams();
            layoutParams.width = (ScreenUtils.getScreenWidth() - SizeUtils.dp2px(60)) / 3;
            itemRoot.setLayoutParams(layoutParams);
        }
    }
}
