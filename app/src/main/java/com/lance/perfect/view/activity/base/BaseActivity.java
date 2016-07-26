package com.lance.perfect.view.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lance.perfect.view.view.base.MvpView;
import com.lance.perfect.view.widget.autolayout.AutoLayoutActivity;


/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/9.
 */
public abstract class BaseActivity extends AutoLayoutActivity implements MvpView {
    protected abstract int getLayoutId();
    protected abstract void initViews();
    protected abstract void initData();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initViews();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showLoading(String msg) {
    }
    @Override
    public void hideLoading() {
    }
    @Override
    public void showError(String msg, View.OnClickListener onClickListener) {
    }
    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener) {
    }
    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener, int imageId) {
    }
    @Override
    public void showNetError(View.OnClickListener onClickListener) {

    }
}
