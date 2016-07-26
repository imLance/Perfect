package com.lance.perfect.view.view.base;

import android.view.View;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/9.
 */
public interface MvpView {
    void showLoading(String msg);
    void hideLoading();
    void showError(String msg, View.OnClickListener onClickListener);
    void showEmpty(String msg, View.OnClickListener onClickListener);
    void showEmpty(String msg, View.OnClickListener onClickListener, int imageId);
    void showNetError(View.OnClickListener onClickListener);
}
