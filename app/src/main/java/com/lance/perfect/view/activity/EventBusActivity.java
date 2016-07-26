package com.lance.perfect.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lance.perfect.R;
import com.lance.perfect.model.EventBusEntity;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.widget.TitleBarView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/28.
 */
public class EventBusActivity extends BaseActivity implements View.OnClickListener {
    private TitleBarView mTitleBarView;
    private LinearLayout mClickMeLayout;
    private TextView mClickTV;
    EventBus mEventBus;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_eventbus;
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
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //第2步:注册一个在后台线程执行的方法,用于接收事件
    public void onEventMainThread(EventBusEntity event) {
        mClickTV.setText("你竟然真点了我，还笑，w~~~");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mClickMeLayout:
                Intent IT=new Intent(this,EventBusPostActivity.class);
                startActivity(IT);
                break;
            default:
                break;
        }
    }
}
