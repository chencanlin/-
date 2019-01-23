package com.ccl.yuedu.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.ccl.yuedu.R;
import com.ccl.yuedu.base.BaseAppCompatActivity;
import com.ccl.yuedu.bean.BookCategoryInfoBean;
import com.ccl.yuedu.bean.BookDetailInfoBean;
import com.ccl.yuedu.constans.CommonExtraKey;
import com.ccl.yuedu.message.CustomMessageInfo;
import com.ccl.yuedu.message.MessageCode;
import com.ccl.yuedu.request.request.CommonService;
import com.ccl.yuedu.utils.BitmapUtil;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailActivity extends BaseAppCompatActivity {

    @BindView(R.id.appbar)
    public AppBarLayout mAppBarLayout;
    @BindView(R.id.toolbar)
    public Toolbar mToolbar;
    @BindView(R.id.rl_cover_bg)
    public RelativeLayout mRlCoverBg;
    @BindView(R.id.iv_cover)
    public ImageView mIvCover;
    @BindView(R.id.tv_book_name)
    public TextView mTvBookName;
    @BindView(R.id.tv_author)
    public TextView mTvAuthor;
    @BindView(R.id.tv_word_count)
    public TextView mTvWordCount;


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
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
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
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supportFinishAfterTransition();
            }
        });
    }

    private void requestBookDetail() {
        if (mBookCategoryInfoBean != null) {
            showLoading();
            CommonService.getBookDetail(mBookCategoryInfoBean.getId());
        }
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected void onNotifyMainThread(CustomMessageInfo customMessageInfo) {
        switch (customMessageInfo.getMessageCode()) {
            case MessageCode.GET_BOOK_DETAIL_SUCCEED:
                dismissLoading();
                Object data = customMessageInfo.getData();
                if (data != null) {
                    BookDetailInfoBean bookDetailInfoBean = (BookDetailInfoBean) data;
                    refreshView(bookDetailInfoBean);
                }
                break;
            case MessageCode.GET_BOOK_DETAIL_FAILED:
                dismissLoading();
                ToastUtils.showShort(customMessageInfo.getMessage());
                break;
        }
    }

    private void refreshView(BookDetailInfoBean bookDetailInfoBean) {
        mToolbar.setTitle(bookDetailInfoBean.getTitle());
        if (!TextUtils.isEmpty(bookDetailInfoBean.getCover())) {
            Picasso.get().load(bookDetailInfoBean.getCover()).into(new Target() {

                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                    mIvCover.setImageBitmap(bitmap);
                    Bitmap bgBitmap = BitmapUtil.rsBlur(BookDetailActivity.this, bitmap, 25, 1/8f);
                    int width = bgBitmap.getWidth();
                    int height = bgBitmap.getHeight();

                    int splitedWidth = width;
                    int splitedHeight = height / 4;

                    Bitmap top = Bitmap.createBitmap(bgBitmap, 0, 0, splitedWidth, splitedHeight);
                    Bitmap bottom = Bitmap.createBitmap(bgBitmap, 0, splitedHeight, splitedWidth, 3 * height / 4);
                    mAppBarLayout.setBackground(new BitmapDrawable(top));
                    mRlCoverBg.setBackground(new BitmapDrawable(bottom));
                    bgBitmap.recycle();
                }

                @Override
                public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                    mIvCover.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.icon_default_cover));
                    Bitmap bgBitmap = BitmapUtil.rsBlur(BookDetailActivity.this, BitmapFactory.decodeResource(getResources(), R.drawable.icon_default_cover), 25, 1 / 4f);
                    int width = bgBitmap.getWidth();
                    int height = bgBitmap.getHeight();

                    int splitedWidth = width;
                    int splitedHeight = height / 4;

                    Bitmap top = Bitmap.createBitmap(bgBitmap, 0, 0, splitedWidth, splitedHeight);
                    Bitmap bottom = Bitmap.createBitmap(bgBitmap, 0, splitedHeight, splitedWidth, 3 * height / 4);
                    mAppBarLayout.setBackground(new BitmapDrawable(top));
                    mRlCoverBg.setBackground(new BitmapDrawable(bottom));
                    bgBitmap.recycle();
                }

                @Override
                public void onPrepareLoad(Drawable placeHolderDrawable) {

                }
            });
        }
        mTvBookName.setText(bookDetailInfoBean.getTitle());
        mTvAuthor.setText(bookDetailInfoBean.getAuthor());
        mTvWordCount.setText(bookDetailInfoBean.getWordCount());
    }
}
