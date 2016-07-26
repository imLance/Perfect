package com.lance.perfect.view.fragment.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.view.base.MvpView;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/23.
 */
public abstract class BaseFragment extends Fragment implements MvpView {
    protected BaseActivity mContext;

    protected abstract int getLayoutId();
    protected abstract void initView(View view, Bundle savedInstanceState);
    protected abstract void initData();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext= (BaseActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View mView=inflater.inflate(getLayoutId(),container,false);
        initView(mView,savedInstanceState);
        initData();
        return mView;
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
