package com.lance.perfect.view.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lance.perfect.R;
import com.lance.perfect.model.EventBusEntity;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.widget.TitleBarView;

import org.greenrobot.eventbus.EventBus;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/28.
 */
public class EventBusPostActivity extends BaseActivity implements View.OnClickListener {
    private TitleBarView mTitleBarView;
    private LinearLayout mClickMeLayout;
    private TextView mClickTV;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_eventbus_post;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView) findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE,"EventBus",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                },null);
        mClickMeLayout= (LinearLayout) findViewById(R.id.mClickMeLayout);
        mClickMeLayout.setOnClickListener(this);
        mClickTV= (TextView) findViewById(R.id.mClickTV);
    }
    @Override
    protected void initData() {
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mClickMeLayout:
                EventBus.getDefault().post(new EventBusEntity("哈哈"));
                break;
            default:
                break;
        }
    }
}
