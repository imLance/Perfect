package com.lance.perfect.view.view;

import com.lance.perfect.model.ContentlistEntity;
import com.lance.perfect.view.view.base.MvpView;

import java.util.List;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/9.
 */
public interface JokeView extends MvpView {
    void refresh(List<ContentlistEntity> data);
    void loadMore(List<ContentlistEntity>  data);
}
