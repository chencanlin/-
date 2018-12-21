package com.ccl.yuedu.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ccl.yuedu.R;
import com.ccl.yuedu.base.BaseAppCompatActivity;

/**
 * Created by chencanlin on 2018/12/20 14:32
 */
public class EditInfoActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        init();
    }
    
    private void init(){
        initView();
    }

    private void initView() {
        
    }
}
