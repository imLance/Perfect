package com.lance.perfect.view.fragment.main;

import android.os.Bundle;
import android.view.View;

import com.lance.perfect.R;
import com.lance.perfect.view.fragment.base.BaseFragment;
import com.lance.perfect.view.widget.TitleBarView;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/24.
 */
public class MessageFragment extends BaseFragment{
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        TitleBarView mTitleBarView= (TitleBarView) view.findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.GONE,View.VISIBLE,View.GONE,"消息中心",null,null);
    }
    @Override
    protected void initData() {
    }
}
