package com.ccl.yuedu.ui.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccl.yuedu.R;
import com.ccl.yuedu.base.BaseFragment;
import com.ccl.yuedu.bean.BookCategoryBean;
import com.ccl.yuedu.bean.BookCategoryFilterBean;
import com.ccl.yuedu.constans.BookCategoryConstants;
import com.ccl.yuedu.constans.CommonExtraKey;
import com.ccl.yuedu.message.CustomMessageInfo;
import com.ccl.yuedu.message.EventBusUtil;
import com.ccl.yuedu.message.MessageCode;
import com.ccl.yuedu.request.request.CommonService;
import com.ccl.yuedu.ui.activity.BookCategoryListActivity;
import com.ccl.yuedu.ui.adapter.BookCategoryRVAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chencanlin on 2018/12/24 15:34
 */
public class BookCategoryFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv_book_category_male)
    RecyclerView mRvBookCategoryMale;
    @BindView(R.id.rv_book_category_female)
    RecyclerView mRvBookCategoryFemale;
    @BindView(R.id.rv_book_category_children)
    RecyclerView mRvBookCategoryChildren;
    @BindView(R.id.rv_book_category_press)
    RecyclerView mRvBookCategoryPress;

    private List<BookCategoryBean> mBookCategoryMaleList = new ArrayList<>();
    private List<BookCategoryBean> mBookCategoryFemaleList = new ArrayList<>();
    private List<BookCategoryBean> mBookCategoryChildrenList = new ArrayList<>();
    private List<BookCategoryBean> mBookCategoryPressList = new ArrayList<>();

    private BookCategoryRVAdapter mBookCategoryMaleRVAdapter;
    private BookCategoryRVAdapter mBookCategoryFemaleRVAdapter;
    private BookCategoryRVAdapter mBookCategoryChildrenRVAdapter;
    private BookCategoryRVAdapter mBookCategoryPressRVAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_book_category, container, false);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
    }

    private void init(View view) {
        GridLayoutManager maleGridLayoutManager = new GridLayoutManager(getContext(), 3);
        maleGridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvBookCategoryMale.setLayoutManager(maleGridLayoutManager);
        mBookCategoryMaleRVAdapter = new BookCategoryRVAdapter(mBookCategoryMaleList, BookCategoryConstants.MALE);
        mRvBookCategoryMale.setAdapter(mBookCategoryMaleRVAdapter);
        mBookCategoryMaleRVAdapter.setOnItemClickListener(this);

        GridLayoutManager femaleGridLayoutManager = new GridLayoutManager(getContext(), 3);
        femaleGridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvBookCategoryFemale.setLayoutManager(femaleGridLayoutManager);
        mBookCategoryFemaleRVAdapter = new BookCategoryRVAdapter(mBookCategoryFemaleList, BookCategoryConstants.FEMALE);
        mRvBookCategoryFemale.setAdapter(mBookCategoryFemaleRVAdapter);
        mBookCategoryFemaleRVAdapter.setOnItemClickListener(this);

        GridLayoutManager childrenGridLayoutManager = new GridLayoutManager(getContext(), 3);
        childrenGridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvBookCategoryChildren.setLayoutManager(childrenGridLayoutManager);
        mBookCategoryChildrenRVAdapter = new BookCategoryRVAdapter(mBookCategoryChildrenList, BookCategoryConstants.PICTURE);
        mRvBookCategoryChildren.setAdapter(mBookCategoryChildrenRVAdapter);
        mBookCategoryChildrenRVAdapter.setOnItemClickListener(this);

        GridLayoutManager pressGridLayoutManager = new GridLayoutManager(getContext(), 3);
        pressGridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvBookCategoryPress.setLayoutManager(pressGridLayoutManager);
        mBookCategoryPressRVAdapter = new BookCategoryRVAdapter(mBookCategoryPressList, BookCategoryConstants.PRESS);
        mRvBookCategoryPress.setAdapter(mBookCategoryPressRVAdapter);
        mBookCategoryPressRVAdapter.setOnItemClickListener(this);

        CommonService.getBookAllCategory(BookCategoryFragment.this.hashCode());
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected void onNotifyMainThread(CustomMessageInfo customMessageInfo) {
        if (EventBusUtil.needHandleMessage(BookCategoryFragment.this.hashCode(), customMessageInfo)) {
            switch (customMessageInfo.getMessageCode()) {
                case MessageCode.GET_BOOK_ALL_CATEGORY_SUCCEED:
                    Map<String, List<BookCategoryBean>> data = (Map<String, List<BookCategoryBean>>) customMessageInfo.getData();

                    mBookCategoryMaleList.addAll(data.get(BookCategoryConstants.MALE));
                    mBookCategoryMaleRVAdapter.notifyDataSetChanged();

                    mBookCategoryFemaleList.addAll(data.get(BookCategoryConstants.FEMALE));
                    mBookCategoryFemaleRVAdapter.notifyDataSetChanged();

                    mBookCategoryChildrenList.addAll(data.get(BookCategoryConstants.PICTURE));
                    mBookCategoryChildrenRVAdapter.notifyDataSetChanged();

                    mBookCategoryPressList.addAll(data.get(BookCategoryConstants.PRESS));
                    mBookCategoryPressRVAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }

    /*@Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

        *//*BookCategoryRVAdapter bookCategoryRVAdapter = (BookCategoryRVAdapter) adapter;
        switch (bookCategoryRVAdapter.getType()) {
            case BookCategoryConstants.MALE:

                break;
            case BookCategoryConstants.FEMALE:

                break;
            case BookCategoryConstants.PICTURE:

                break;
            case BookCategoryConstants.PRESS:

                break;
        }*//*
    }*/

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        BookCategoryRVAdapter bookCategoryRVAdapter = (BookCategoryRVAdapter) adapter;
        Intent intent = new Intent(getActivity(), BookCategoryListActivity.class);
        String major = "";
        switch (bookCategoryRVAdapter.getType()) {
            case BookCategoryConstants.MALE:
                major = mBookCategoryMaleList.get(position).getName();
                break;
            case BookCategoryConstants.FEMALE:
                major = mBookCategoryFemaleList.get(position).getName();
                break;
            case BookCategoryConstants.PICTURE:
                major = mBookCategoryChildrenList.get(position).getName();
                break;
            case BookCategoryConstants.PRESS:
                major = mBookCategoryPressList.get(position).getName();
                break;
        }
        BookCategoryFilterBean bookCategoryFilterBean = new BookCategoryFilterBean(bookCategoryRVAdapter.getType(), BookCategoryConstants.BookCategoryFilter.HOT, major);
        intent.putExtra(CommonExtraKey.EXTRA_KEY_BOOK_CATEGORY_FILTER_BEAN, bookCategoryFilterBean);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), view, view.getTransitionName());
            startActivity(intent, optionsCompat.toBundle());
        } else {
            startActivity(intent);
        }
    }
}
