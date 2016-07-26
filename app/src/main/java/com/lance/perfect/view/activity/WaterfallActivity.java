package com.lance.perfect.view.activity;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.lance.perfect.R;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.adapter.WaterfallAdapter;
import com.lance.perfect.view.widget.TitleBarView;
import com.lance.perfect.view.widget.pullToRefresh.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用:  瀑布流
 * 作者： 张甲彪
 * 时间： 2016/5/27.
 */
public class WaterfallActivity extends BaseActivity implements
        PullLoadMoreRecyclerView.PullLoadMoreListener {
    private TitleBarView mTitleBarView;
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_waterfall;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView) findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE,"瀑布流",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                },null);
        mPullLoadMoreRecyclerView
                = (PullLoadMoreRecyclerView) findViewById(R.id.mPullLoadMoreRecyclerView);
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        mPullLoadMoreRecyclerView.mRecyclerView.setLayoutManager(mLayoutManager);
        mPullLoadMoreRecyclerView.setRefreshing(false);
//        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(this);
    }
    @Override
    protected void initData() {
        List<String> mList=new ArrayList<>();
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=21b2eb24563d269731d30e5d65fab24f/64380cd7912397dd201a4eea5e82b2b7d1a287f9.jpg");
        mList.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=9e943216a086c91717035539f93c70c6/4afbfbedab64034f73ae14e8a8c379310b551df8.jpg");
        mList.add("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=875aa8d07fec54e75eec1d1e89399bfd/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D360/sign=51650b06b83eb1355bc7b1bd961fa8cb/7a899e510fb30f2493c8cbedcc95d143ac4b0389.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=21b2eb24563d269731d30e5d65fab24f/64380cd7912397dd201a4eea5e82b2b7d1a287f9.jpg");
        mList.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=9e943216a086c91717035539f93c70c6/4afbfbedab64034f73ae14e8a8c379310b551df8.jpg");
        mList.add("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=875aa8d07fec54e75eec1d1e89399bfd/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D360/sign=51650b06b83eb1355bc7b1bd961fa8cb/7a899e510fb30f2493c8cbedcc95d143ac4b0389.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=21b2eb24563d269731d30e5d65fab24f/64380cd7912397dd201a4eea5e82b2b7d1a287f9.jpg");
        mList.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=9e943216a086c91717035539f93c70c6/4afbfbedab64034f73ae14e8a8c379310b551df8.jpg");
        mList.add("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=875aa8d07fec54e75eec1d1e89399bfd/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D360/sign=51650b06b83eb1355bc7b1bd961fa8cb/7a899e510fb30f2493c8cbedcc95d143ac4b0389.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=21b2eb24563d269731d30e5d65fab24f/64380cd7912397dd201a4eea5e82b2b7d1a287f9.jpg");
        mList.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=9e943216a086c91717035539f93c70c6/4afbfbedab64034f73ae14e8a8c379310b551df8.jpg");
        mList.add("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=875aa8d07fec54e75eec1d1e89399bfd/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D360/sign=51650b06b83eb1355bc7b1bd961fa8cb/7a899e510fb30f2493c8cbedcc95d143ac4b0389.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=21b2eb24563d269731d30e5d65fab24f/64380cd7912397dd201a4eea5e82b2b7d1a287f9.jpg");
        mList.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=9e943216a086c91717035539f93c70c6/4afbfbedab64034f73ae14e8a8c379310b551df8.jpg");
        mList.add("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=875aa8d07fec54e75eec1d1e89399bfd/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D360/sign=51650b06b83eb1355bc7b1bd961fa8cb/7a899e510fb30f2493c8cbedcc95d143ac4b0389.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=21b2eb24563d269731d30e5d65fab24f/64380cd7912397dd201a4eea5e82b2b7d1a287f9.jpg");
        mList.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=9e943216a086c91717035539f93c70c6/4afbfbedab64034f73ae14e8a8c379310b551df8.jpg");
        mList.add("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=875aa8d07fec54e75eec1d1e89399bfd/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D360/sign=51650b06b83eb1355bc7b1bd961fa8cb/7a899e510fb30f2493c8cbedcc95d143ac4b0389.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=21b2eb24563d269731d30e5d65fab24f/64380cd7912397dd201a4eea5e82b2b7d1a287f9.jpg");
        mList.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=9e943216a086c91717035539f93c70c6/4afbfbedab64034f73ae14e8a8c379310b551df8.jpg");
        mList.add("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=875aa8d07fec54e75eec1d1e89399bfd/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D360/sign=51650b06b83eb1355bc7b1bd961fa8cb/7a899e510fb30f2493c8cbedcc95d143ac4b0389.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=21b2eb24563d269731d30e5d65fab24f/64380cd7912397dd201a4eea5e82b2b7d1a287f9.jpg");
        mList.add("https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=9e943216a086c91717035539f93c70c6/4afbfbedab64034f73ae14e8a8c379310b551df8.jpg");
        mList.add("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=875aa8d07fec54e75eec1d1e89399bfd/241f95cad1c8a7866f726fe06309c93d71cf5087.jpg");
        mList.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D360/sign=51650b06b83eb1355bc7b1bd961fa8cb/7a899e510fb30f2493c8cbedcc95d143ac4b0389.jpg");
        WaterfallAdapter mAdapter=new WaterfallAdapter(this,mList);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }
    @Override
    public void onRefresh() {
    }
    @Override
    public void onLoadMore() {
    }
}
