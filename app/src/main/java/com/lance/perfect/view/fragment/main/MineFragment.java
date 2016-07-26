package com.lance.perfect.view.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lance.perfect.R;
import com.lance.perfect.domain.util.GlideUtils;
import com.lance.perfect.model.MineLearnEntity;
import com.lance.perfect.view.activity.CustomViewActivity;
import com.lance.perfect.view.activity.EventBusActivity;
import com.lance.perfect.view.activity.GreenDaoActivity;
import com.lance.perfect.view.activity.LoadingActivity;
import com.lance.perfect.view.activity.PersonalActivity;
import com.lance.perfect.view.activity.TextViewActivity;
import com.lance.perfect.view.activity.TimeSelectorActivity;
import com.lance.perfect.view.activity.UCropActivity;
import com.lance.perfect.view.activity.WXCircleVideoActivity;
import com.lance.perfect.view.activity.WaterfallActivity;
import com.lance.perfect.view.activity.WebViewActivity;
import com.lance.perfect.view.adapter.MineListAdapter;
import com.lance.perfect.view.fragment.base.BaseFragment;
import com.lance.perfect.view.widget.TitleBarView;
import com.lance.perfect.view.widget.pullToRefresh.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/24.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    /**个人信息布局*/
    private RelativeLayout mPersonalLayout;
    /**个人头像*/
    private ImageView mTouXiangIV;
    /**标题栏*/
    private TitleBarView mTitleBarView;

    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mTitleBarView= (TitleBarView) view.findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.GONE,View.VISIBLE,View.GONE,"我的",null,null);
        mTouXiangIV= (ImageView) view.findViewById(R.id.mTouXiangIV);
        GlideUtils.loadCircleImage(mContext,
                "http://img2.imgtn.bdimg.com/it/u=3065510176,2216713784&fm=21&gp=0.jpg",mTouXiangIV);
        mPersonalLayout= (RelativeLayout) view.findViewById(R.id.mPersonalLayout);
        mPersonalLayout.setOnClickListener(this);
        mPullLoadMoreRecyclerView=
                (PullLoadMoreRecyclerView) view.findViewById(R.id.mPullLoadMoreRecyclerView);
        mPullLoadMoreRecyclerView.setLinearLayout();
    }
    @Override
    protected void initData() {
        List<MineLearnEntity> mList=new ArrayList<>();
        mList.add(new MineLearnEntity("GreenDao数据库学习",GreenDaoActivity.class.getName()));
        mList.add(new MineLearnEntity("WebViewActivity",WebViewActivity.class.getName()));
        mList.add(new MineLearnEntity("UCrop学习",UCropActivity.class.getName()));
        mList.add(new MineLearnEntity("RecyclerView实现瀑布流效果",WaterfallActivity.class.getName()));
        mList.add(new MineLearnEntity("朋友圈视频的滚动播放功能",WXCircleVideoActivity.class.getName()));
        mList.add(new MineLearnEntity("EventBus解耦学习",EventBusActivity.class.getName()));
        mList.add(new MineLearnEntity("重新认识下TextView", TextViewActivity.class.getName()));
        mList.add(new MineLearnEntity("自定义View学习", CustomViewActivity.class.getName()));
        mList.add(new MineLearnEntity("加载动画",LoadingActivity.class.getName()));
        mList.add(new MineLearnEntity("时间选择器",TimeSelectorActivity.class.getName()));
        MineListAdapter mAdapter=new MineListAdapter(mList,mContext);
        mPullLoadMoreRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mPersonalLayout:
                Intent IT=new Intent(mContext,PersonalActivity.class);
                mContext.startActivity(IT);
                break;
            default:
                break;
        }
    }
}
