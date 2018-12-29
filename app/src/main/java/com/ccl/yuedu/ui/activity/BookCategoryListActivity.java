package com.ccl.yuedu.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.ccl.yuedu.R;
import com.ccl.yuedu.base.BaseAppCompatActivity;
import com.ccl.yuedu.bean.BookCategoryFilterBean;
import com.ccl.yuedu.bean.BookCategoryInfoBean;
import com.ccl.yuedu.constans.BookCategoryConstants;
import com.ccl.yuedu.constans.CommonExtraKey;
import com.ccl.yuedu.message.CustomMessageInfo;
import com.ccl.yuedu.message.MessageCode;
import com.ccl.yuedu.request.request.CommonService;
import com.ccl.yuedu.ui.adapter.BookListRVAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chencanlin on 2018/12/25 14:16
 */
public class BookCategoryListActivity extends BaseAppCompatActivity implements View.OnClickListener {

    private View mInflate;

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @BindView(R.id.rv_book_list)
    public RecyclerView mRvBookList;
    //    @BindView(R.id.ll_sort)
//    public LinearLayout mLLSort;
    @BindView(R.id.right_labels)
    FloatingActionsMenu mFloatingActionsMenu;
    @BindView(R.id.fab_follower)
    FloatingActionButton mFabFollower;
    @BindView(R.id.fab_update)
    FloatingActionButton mFabUpdate;
    @BindView(R.id.fab_reputation)
    FloatingActionButton mFabReputation;
    @BindView(R.id.fab_over)
    FloatingActionButton mFabOver;

    private int start = 0;
    private int limit = 10;
    private boolean needClearData = false;


    private BookCategoryFilterBean mBookCategoryFilterBean;
    private List<BookCategoryInfoBean> mBookCategoryInfoBeanList = new ArrayList<>();
    private BookListRVAdapter mBookListRVAdapter;
    private String currentSortType = BookCategoryConstants.BookCategoryFilter.HOT;
    private List<FloatingActionButton> mFloatingActionButtonList = new ArrayList<>();

    public String getCurrentSortType() {
        return currentSortType;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_category_list);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initView();
        initData();
        setView();
    }

    private void initView() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supportFinishAfterTransition();
            }
        });

//        mLLSort.setOnClickListener(this);

        mBookListRVAdapter = new BookListRVAdapter(mBookCategoryInfoBeanList);
        mBookListRVAdapter.setLoadMoreView(new SimpleLoadMoreView());
        mBookListRVAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                requestBookList(false);
            }
        }, mRvBookList);
//        mBookListRVAdapter.disableLoadMoreIfNotFullPage(mRvBookList);
//        mBookListRVAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvBookList.setLayoutManager(linearLayoutManager);
        mRvBookList.setAdapter(mBookListRVAdapter);
        mBookListRVAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BookDetailActivity.start(BookCategoryListActivity.this, mBookCategoryInfoBeanList.get(position));
            }
        });

        mFloatingActionButtonList.add(mFabFollower);
        mFloatingActionButtonList.add(mFabUpdate);
        mFloatingActionButtonList.add(mFabReputation);
        mFloatingActionButtonList.add(mFabOver);
        mFabFollower.setOnClickListener(this);
        mFabUpdate.setOnClickListener(this);
        mFabReputation.setOnClickListener(this);
        mFabOver.setOnClickListener(this);
        mFloatingActionsMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                setCurrentSortViewStatus(currentSortType);
            }

            @Override
            public void onMenuCollapsed() {

            }
        });
    }

    private void setCurrentSortViewStatus(String currentSortType) {
        for (FloatingActionButton item : mFloatingActionButtonList) {
            Object view = item.getTag(com.getbase.floatingactionbutton.R.id.fab_label);
            if (currentSortType.equalsIgnoreCase((String) item.getTag())) {
                item.setEnabled(false);
                if (view instanceof TextView) {
                    ((TextView) view).setEnabled(false);
                }
            } else {
                item.setEnabled(true);
                if (view instanceof TextView) {
                    ((TextView) view).setEnabled(true);
                }
            }
        }
    }

    private void setView() {
        if (mBookCategoryFilterBean != null) {
            setTitle(mBookCategoryFilterBean.getMajor());
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mBookCategoryFilterBean = intent.getParcelableExtra(CommonExtraKey.EXTRA_KEY_BOOK_CATEGORY_FILTER_BEAN);
        }
        requestBookList(true);
    }

    private void requestBookList(boolean showMask) {
        if (mBookCategoryFilterBean != null) {
            if (showMask) {
                showLoading();
            }
            CommonService.getBookListByCategory(mBookCategoryFilterBean.getType(), currentSortType, mBookCategoryFilterBean.getMajor(), start, limit);
        }
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected void onNotifyMainThread(CustomMessageInfo customMessageInfo) {
        switch (customMessageInfo.getMessageCode()) {
            case MessageCode.GET_BOOK_LIST_BY_CATEGORY_SUCCEED:
                List<BookCategoryInfoBean> data = (List<BookCategoryInfoBean>) customMessageInfo.getData();
                if (needClearData) {
                    needClearData = false;
                    mBookCategoryInfoBeanList.clear();
                    mBookListRVAdapter.notifyDataSetChanged();
                }
                if (data != null && data.size() > 0) {
                    mBookListRVAdapter.addData(data);
                    mBookListRVAdapter.loadMoreComplete();
                    start += data.size();
                } else {
                    mBookListRVAdapter.loadMoreEnd();
                }
                dismissLoading();
                break;
            case MessageCode.GET_BOOK_LIST_BY_CATEGORY_FAILED:
                dismissLoading();
                mBookListRVAdapter.loadMoreFail();
                String message = customMessageInfo.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    ToastUtils.showShort(message);
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.ll_sort:
                mLLSort.setSelected(!mLLSort.isSelected());
                break;*/
            case R.id.fab_follower:
            case R.id.fab_update:
            case R.id.fab_reputation:
            case R.id.fab_over:
                currentSortType = (String) v.getTag();
                mFloatingActionsMenu.collapseImmediately();
                needClearData = true;
                start = 0;
                requestBookList(true);
                break;
        }
    }
}
