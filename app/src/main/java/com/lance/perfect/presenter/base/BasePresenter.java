package com.lance.perfect.presenter.base;

import com.lance.perfect.view.view.base.MvpView;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/9.
 */
public class BasePresenter<T extends MvpView> implements Presenter<T>{
    private T mMvpView;
    @Override
    public void attachView(T mvpView) {
        mMvpView=mvpView;
    }
    @Override
    public void detachView() {
        mMvpView=null;
    }
    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
