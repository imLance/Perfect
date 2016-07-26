package com.lance.perfect.view.activity;

import android.view.View;

import com.lance.perfect.R;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.fragment.WXCircleVideoFragment;
import com.lance.perfect.view.widget.TitleBarView;

/**
 * 作用:  微信朋友圈视频播放
 * 作者： 张甲彪
 * 时间： 2016/5/27.
 */
public class WXCircleVideoActivity extends BaseActivity{
    public static final int LOCAL = 0; // 本地
    public static final int ONLINE = 1; // 在线
    private TitleBarView mTitleBarView;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_wxcircle_video;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView) findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE,"微信朋友圈视频播放",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                },null);
    }
    @Override
    protected void initData() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mContextLayout, WXCircleVideoFragment.newInstance(LOCAL))
                .commit();
    }

}
