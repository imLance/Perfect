package com.lance.perfect.view.fragment.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.lance.perfect.R;
import com.lance.perfect.domain.util.ToastUtils;
import com.lance.perfect.model.ContentlistEntity;
import com.lance.perfect.presenter.JokePresenter;
import com.lance.perfect.view.adapter.JokeAdapter;
import com.lance.perfect.view.fragment.base.BaseFragment;
import com.lance.perfect.view.view.JokeView;
import com.lance.perfect.view.widget.TitleBarView;
import com.lance.perfect.view.widget.pullToRefresh.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/24.
 */
public class HomeFragment extends BaseFragment implements JokeView
        , PullLoadMoreRecyclerView.PullLoadMoreListener{
    PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;

    ArrayList jokeList;
    JokeAdapter jokeAdapter;
    private JokePresenter jokePresenter;
    int curPage = 1;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) view.findViewById(R.id.mPullLoadMoreRecyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        mPullLoadMoreRecyclerView.mRecyclerView.setLayoutManager(mLayoutManager);
        mPullLoadMoreRecyclerView.setRefreshing(true);
        mPullLoadMoreRecyclerView.setLinearLayout();
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
        TitleBarView mTitleBarView= (TitleBarView) view.findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.GONE,View.VISIBLE,View.GONE,"快乐么么哒",null,null);
    }
    @Override
    protected void initData() {
        jokeList = new ArrayList<>();
        jokeAdapter = new JokeAdapter(jokeList);
        mPullLoadMoreRecyclerView.setAdapter(jokeAdapter);
        curPage = 1;
        jokePresenter = new JokePresenter();
        jokePresenter.attachView(this);
        loadData();
    }
    private void loadData() {
        jokePresenter.loadList(curPage);
        curPage++;
    }
    @Override
    public void refresh(List<ContentlistEntity> data) {
        jokeList.clear();
        jokeList.addAll(data);
        jokeAdapter.notifyDataSetChanged();
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void loadMore(List<ContentlistEntity> data) {
        jokeList.addAll(data);
        jokeAdapter.notifyDataSetChanged();
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void showError(String msg, View.OnClickListener onClickListener) {
        super.showError(msg, onClickListener);
        ToastUtils.showShort(msg);
        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void onRefresh() {
        curPage = 1;
        loadData();
    }

    @Override
    public void onLoadMore() {
        loadData();
    }
}
