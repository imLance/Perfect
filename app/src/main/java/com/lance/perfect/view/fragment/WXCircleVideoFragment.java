package com.lance.perfect.view.fragment;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.lance.perfect.R;
import com.lance.perfect.model.LocalWXVideoEntity;
import com.lance.perfect.model.OnlineWXVideoEntity;
import com.lance.perfect.model.WXVideoEntity;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.adapter.WXVideoAdapter;
import com.volokh.danylo.video_player_manager.manager.PlayerItemChangeListener;
import com.volokh.danylo.video_player_manager.manager.SingleVideoPlayerManager;
import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.meta.MetaData;
import com.volokh.danylo.visibility_utils.calculator.DefaultSingleItemCalculatorCallback;
import com.volokh.danylo.visibility_utils.calculator.ListItemsVisibilityCalculator;
import com.volokh.danylo.visibility_utils.calculator.SingleListViewItemActiveCalculator;
import com.volokh.danylo.visibility_utils.scroll_utils.ItemsPositionGetter;
import com.volokh.danylo.visibility_utils.scroll_utils.RecyclerViewItemPositionGetter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 作用:  微信视频列表
 * 作者： 张甲彪
 * 时间： 2016/5/27.
 */
public class WXCircleVideoFragment extends Fragment{
    private View mBaseView;
    private RecyclerView mRecyclerView;
    private BaseActivity mContext;

    public static final String VIDEO_TYPE_ARG = "me.chunyu.spike.video_list_fragment.video_type_arg";
    // 网络视频地址
    private static final String URL =
            "http://dn-chunyu.qbox.me/fwb/static/images/home/video/video_aboutCY_A.mp4";
    // 本地资源文件名
    private static final String[] LOCAL_NAMES = new String[]{
            "chunyu-local-1.mp4",
            "chunyu-local-2.mp4",
            "chunyu-local-3.mp4",
            "chunyu-local-4.mp4"
    };
    // 在线资源名
    private static final String ONLINE_NAME = "chunyu-online";

    private final ArrayList<WXVideoEntity> mList; // 视频项的列表
    private final ListItemsVisibilityCalculator mVisibilityCalculator; // 可视估计器
    private final VideoPlayerManager<MetaData> mVideoPlayerManager;
    private LinearLayoutManager mLayoutManager; // 布局管理器
    private ItemsPositionGetter mItemsPositionGetter; // 位置提取器
    private int mScrollState; // 滑动状态

    // 创建实例, 添加类型
    public static WXCircleVideoFragment newInstance(int type) {
        WXCircleVideoFragment simpleFragment = new WXCircleVideoFragment();
        Bundle args = new Bundle();
        args.putInt(VIDEO_TYPE_ARG, type);
        simpleFragment.setArguments(args);
        return simpleFragment;
    }
    public WXCircleVideoFragment(){
        mList = new ArrayList<>();
        mVisibilityCalculator = new SingleListViewItemActiveCalculator(
                new DefaultSingleItemCalculatorCallback(), mList);
        mVideoPlayerManager = new SingleVideoPlayerManager(new PlayerItemChangeListener() {
            @Override
            public void onPlayerItemChanged(MetaData metaData) {
            }
        });

        mScrollState = AbsListView.OnScrollListener.SCROLL_STATE_IDLE; // 暂停滚动状态
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mContext= (BaseActivity) getContext();
        mBaseView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_wxcircle_video, container, false);
        initViews();
        initData();
        return mBaseView;
    }
    public void onResume() {
        super.onResume();
        if (!mList.isEmpty()) {
            mRecyclerView.post(new Runnable() {
                @Override
                public void run() {
                    // 判断一些滚动状态
                    mVisibilityCalculator.onScrollStateIdle(
                            mItemsPositionGetter,
                            mLayoutManager.findFirstVisibleItemPosition(),
                            mLayoutManager.findLastVisibleItemPosition());

                }
            });
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        mVideoPlayerManager.resetMediaPlayer(); // 页面不显示时, 释放播放器
    }

    private void initViews() {
        mRecyclerView= (RecyclerView) mBaseView.findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void initData() {
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[0], R.drawable.cover, getFile(LOCAL_NAMES[0])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[1], R.drawable.cover, getFile(LOCAL_NAMES[1])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[2], R.drawable.cover, getFile(LOCAL_NAMES[2])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[3], R.drawable.cover, getFile(LOCAL_NAMES[3])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[0], R.drawable.cover, getFile(LOCAL_NAMES[0])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[1], R.drawable.cover, getFile(LOCAL_NAMES[1])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[2], R.drawable.cover, getFile(LOCAL_NAMES[2])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[3], R.drawable.cover, getFile(LOCAL_NAMES[3])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[0], R.drawable.cover, getFile(LOCAL_NAMES[0])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[1], R.drawable.cover, getFile(LOCAL_NAMES[1])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[2], R.drawable.cover, getFile(LOCAL_NAMES[2])));
        mList.add(new LocalWXVideoEntity(mVideoPlayerManager, LOCAL_NAMES[3], R.drawable.cover, getFile(LOCAL_NAMES[3])));
        final int count = 10;
        for (int i = 0; i < count; ++i) {
            mList.add(new OnlineWXVideoEntity(mVideoPlayerManager, ONLINE_NAME, R.drawable.cover, URL));
        }

        WXVideoAdapter mAdapter=new WXVideoAdapter(mList,mContext);
        mRecyclerView.setAdapter(mAdapter);
        // 获取Item的位置
        mItemsPositionGetter = new RecyclerViewItemPositionGetter(mLayoutManager, mRecyclerView);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
                mScrollState = scrollState;
                if (scrollState == RecyclerView.SCROLL_STATE_IDLE && !mList.isEmpty()) {
                    mVisibilityCalculator.onScrollStateIdle(
                            mItemsPositionGetter,
                            mLayoutManager.findFirstVisibleItemPosition(),
                            mLayoutManager.findLastVisibleItemPosition());
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!mList.isEmpty()) {
                    mVisibilityCalculator.onScroll(
                            mItemsPositionGetter,
                            mLayoutManager.findFirstVisibleItemPosition(),
                            mLayoutManager.findLastVisibleItemPosition() -
                                    mLayoutManager.findFirstVisibleItemPosition() + 1,
                            mScrollState);
                }
            }
        });
    }
    // 获取资源文件
    private AssetFileDescriptor getFile(String name) {
        try {
            return mContext.getAssets().openFd(name);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
