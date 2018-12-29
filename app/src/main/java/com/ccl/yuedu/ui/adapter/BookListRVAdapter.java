package com.ccl.yuedu.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccl.yuedu.R;
import com.ccl.yuedu.YDApplication;
import com.ccl.yuedu.bean.BookInfoBean;
import com.ccl.yuedu.constans.BookCategoryConstants;
import com.ccl.yuedu.ui.activity.BookCategoryListActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chencanlin on 2018/12/26 10:24
 */
public class BookListRVAdapter extends BaseQuickAdapter<BookInfoBean, BaseViewHolder> {

    public BookListRVAdapter(@Nullable List<BookInfoBean> data) {
        super(R.layout.layout_book_list_rv_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookInfoBean item) {
        ImageView mIvCover = helper.getView(R.id.iv_cover);
        if (TextUtils.isEmpty(item.getCover())) {
            Picasso.get().load(R.drawable.icon_default_cover).into(mIvCover);
        } else {
            Picasso.get().load(item.getCover()).error(R.drawable.icon_default_cover).placeholder(R.drawable.icon_default_cover).into(mIvCover);
        }
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_short_intro, item.getShortIntro());
        helper.setText(R.id.tv_author, item.getAuthor());
        helper.setText(R.id.tv_minor_cate, item.getMinorCate());
        helper.getView(R.id.tv_minor_cate).setVisibility(TextUtils.isEmpty(item.getMinorCate()) ? View.GONE : View.VISIBLE);
        String latelyFollower = item.getLatelyFollower();
        int i = 10000;
        try {
            i = Integer.parseInt(latelyFollower);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String numberStr;
        if (i >= 10000) {
            numberStr = String.format("%.1f", i / 10000f) + "万";
        } else {
            numberStr = String.valueOf(i);
        }
        Context context = getRecyclerView().getContext();
        TextView tvLatelyFollower = helper.getView(R.id.tv_lately_follower);
        if (context instanceof BookCategoryListActivity) {
            BookCategoryListActivity bookCategoryListActivity = (BookCategoryListActivity) context;
            String currentSortType = bookCategoryListActivity.getCurrentSortType();
            String str;
            if (BookCategoryConstants.BookCategoryFilter.REPUTATION.equalsIgnoreCase(currentSortType)) {
                str = YDApplication.getInstance().getResources().getString(R.string.book_list_reputation, item.getRetentionRatio() + "%");
            } else {
                str = YDApplication.getInstance().getResources().getString(R.string.book_list_lately_follower, numberStr);
            }
            tvLatelyFollower.setText(str);
            tvLatelyFollower.setVisibility(View.VISIBLE);
        } else {
            tvLatelyFollower.setVisibility(View.GONE);
        }
    }
}
