package com.lance.perfect.view.activity;

import android.view.View;

import com.lance.perfect.R;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.widget.TitleBarView;

/**
 * 作用:  自定义View
 * 作者： 张甲彪
 * 时间： 2016/5/31.
 */
public class CustomViewActivity extends BaseActivity{
    private TitleBarView mTitleBarView;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_view;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView) findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE,"自定义View",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                },null);
    }
    @Override
    protected void initData() {
    }
}
