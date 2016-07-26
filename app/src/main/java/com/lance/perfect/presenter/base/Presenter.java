package com.lance.perfect.presenter.base;

import com.lance.perfect.view.view.base.MvpView;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/9.
 */
public interface Presenter<V extends MvpView> {
    void attachView(V mvpView);
    void detachView();
}
