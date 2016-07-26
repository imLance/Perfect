package com.lance.perfect.view.activity;

import android.view.View;
import android.widget.Toast;

import com.lance.perfect.R;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.widget.TitleBarView;

import org.feezu.liuli.timeselector.TimeSelector;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/6/20.
 */
public class TimeSelectorActivity extends BaseActivity{
    private TitleBarView mTitleBarView;
    private TimeSelector timeSelector;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_time_selector;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView) findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE,"时间选择器",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                },null);
        timeSelector = new TimeSelector(this, new TimeSelector.ResultHandler() {
            @Override
            public void handle(String time) {
                Toast.makeText(getApplicationContext(), time, Toast.LENGTH_LONG).show();
            }
        }, "1989-01-30 00:00", "2018-12-31 00:00");
        timeSelector.setMode(TimeSelector.MODE.YMD);
        timeSelector.show();
    }
    @Override
    protected void initData() {
    }
}
