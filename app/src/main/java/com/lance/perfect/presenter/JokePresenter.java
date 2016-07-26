package com.lance.perfect.presenter;

import com.lance.perfect.domain.api.JokeApi;
import com.lance.perfect.domain.api.RxService;
import com.lance.perfect.model.ContentlistEntity;
import com.lance.perfect.model.JokeEntity;
import com.lance.perfect.presenter.base.BasePresenter;
import com.lance.perfect.view.view.JokeView;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/9.
 */
public class JokePresenter extends BasePresenter<JokeView> {
    @Override
    public void attachView(JokeView mvpView) {
        super.attachView(mvpView);
    }
    @Override
    public void detachView() {
        super.detachView();
    }
    public void loadList(final int page){
        RxService.createApi(JokeApi.class)
                .getJoke(page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<JokeEntity, List<ContentlistEntity>>() {
                    @Override
                    public List<ContentlistEntity> call(JokeEntity jokeEntity) {
                        return jokeEntity.getShowapi_res_body().getContentlist();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ContentlistEntity>>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(e.getMessage(), null);
                    }
                    @Override
                    public void onNext(List<ContentlistEntity> contentlistEntities) {
                        if (page==1){
                            getMvpView().refresh(contentlistEntities);
                        }else {
                            getMvpView().loadMore(contentlistEntities);
                        }
                    }
                });
    }
}
