package com.ccl.yuedu.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.ccl.yuedu.R;
import com.ccl.yuedu.base.BaseAppCompatActivity;
import com.ccl.yuedu.bean.PeronalInfo;
import com.ccl.yuedu.constans.CommonExtraKey;
import com.ccl.yuedu.utils.BitmapUtil;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseAppCompatActivity implements View.OnClickListener {

    @BindView(R.id.drawer_layout)
    public DrawerLayout mDrawerLayout;
    @BindView(R.id.nv_main)
    public NavigationView mNvMain;
    private View mHeadLayout;
    private TextView mTvIntro;
    private ImageView mIvAvatar;
    private TextView mTvName;
    private View mLlIntro;
    private Toolbar mToolbar;
    private SearchView mSearchView;
    private PeronalInfo mPersonalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            BarUtils.setStatusBarAlpha(this, 36);
        }
        init();
    }

    private void init() {
        initView();
        initData();
        setView();
    }

    private void setView() {
//        Bitmap bitmap = BitmapUtil.rsBlur(this, BitmapFactory.decodeResource(getResources(), R.drawable.shuijingshinv), 25, 1 / 4f);
//        mHeadLayout.setBackground(new BitmapDrawable(bitmap));
        if (mPersonalInfo != null) {
            try {
                Picasso.get().load(Uri.parse(mPersonalInfo.avatarUrl)).into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        mIvAvatar.setImageBitmap(bitmap);
                        Bitmap bgBitmap = BitmapUtil.rsBlur(MainActivity.this, bitmap, 25, 4);
                        mHeadLayout.setBackground(new BitmapDrawable(bgBitmap));
                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                        mIvAvatar.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.avatar_default));
                        Bitmap bgBitmap = BitmapUtil.rsBlur(MainActivity.this, BitmapFactory.decodeResource(getResources(), R.drawable.shuijingshinv), 25, 1 / 4f);
                        mHeadLayout.setBackground(new BitmapDrawable(bgBitmap));
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            mTvName.setText(mPersonalInfo.name);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mPersonalInfo = intent.getParcelableExtra(CommonExtraKey.EXTRA_KEY_PERSONAL_INFO);
        }
    }

    private void initView() {
        initDrawerView();
        initToolbar();


        addViewListener();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (KeyboardUtils.isSoftInputVisible(MainActivity.this)) {
                    KeyboardUtils.hideSoftInput(MainActivity.this);
                }
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_search:

                        break;
                }
                return true;
            }
        });
    }

    private void initDrawerView() {
        mHeadLayout = mNvMain.getHeaderView(0);
        Bitmap bitmap = BitmapUtil.rsBlur(this, BitmapFactory.decodeResource(getResources(), R.drawable.shuijingshinv), 25, 1 / 4f);
        mHeadLayout.setBackground(new BitmapDrawable(bitmap));

        mIvAvatar = mHeadLayout.findViewById(R.id.iv_avatar);
        mTvName = mHeadLayout.findViewById(R.id.tv_name);
        mLlIntro = mHeadLayout.findViewById(R.id.ll_intro);
        mTvIntro = mHeadLayout.findViewById(R.id.tv_intro);
        mTvIntro.post(new Runnable() {
            @Override
            public void run() {
                mTvIntro.setMaxWidth(mHeadLayout.getMeasuredWidth() - SizeUtils.dp2px(71));
            }
        });
        mTvIntro.setText(getResources().getString(R.string.main_intro, "书海洗澡，静享精华"));
    }

    private void addViewListener() {
        mLlIntro.setOnClickListener(this);
        mNvMain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Toast.makeText(MainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_intro:

                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_toolbar, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search);

        //通过MenuItem得到SearchView
        mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setQueryHint("请输入书名或作者姓名");
        return true;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }
}
