package com.ccl.yuedu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.ccl.yuedu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chencanlin on 2018/12/25 14:30
 */
public abstract class BaseToolbarAppcompatActivity extends BaseAppCompatActivity {

    public FrameLayout mFlContainer;
    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_toolbar_appcompat);
        mFlContainer = findViewById(R.id.fl_container);
        View childView = createView(mFlContainer);
        init(childView);
    }

    private void init(View childView) {
        mFlContainer.addView(childView);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void setTitle(String title) {
        mToolbar.setTitle(title);
    }

    public void setTitle(int strId) {
        mToolbar.setTitle(strId);
    }

    public abstract View createView(FrameLayout container);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            supportFinishAfterTransition();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
