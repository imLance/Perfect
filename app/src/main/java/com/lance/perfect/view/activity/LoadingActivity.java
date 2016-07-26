package com.lance.perfect.view.activity;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ChasingDots;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.CubeGrid;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.github.ybq.android.spinkit.style.FoldingCube;
import com.github.ybq.android.spinkit.style.Pulse;
import com.github.ybq.android.spinkit.style.RotatingPlane;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;
import com.lance.perfect.R;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.widget.TitleBarView;
import java.util.Random;

/**
 * 作用:  加载动画
 * 作者： 张甲彪
 * 时间： 2016/6/3.
 * maven { url "https://jitpack.io" }
 * compile 'com.github.ybq:Android-SpinKit:1.0.4'
 * https://github.com/ybq/Android-SpinKit
 */

public class LoadingActivity extends BaseActivity{

    private TitleBarView mTitleBarView;
    private SpinKitView mSpinKitView;
    private TextView mChangeTV;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_loading;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView) findViewById(R.id.mTitleBarView);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE,"加载动画",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                },null);
        mSpinKitView= (SpinKitView) findViewById(R.id.mSpinKitView);
        mSpinKitView.setIndeterminateDrawable(new ThreeBounce());
        mChangeTV= (TextView) findViewById(R.id.mChangeTV);
        mChangeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDrawable();
            }
        });
    }

    private void changeDrawable() {
        Sprite drawable = null;
        int position=new Random().nextInt(11);
        switch (position) {
            case 0:
                drawable = new RotatingPlane();
                break;
            case 1:
                drawable = new DoubleBounce();
                break;
            case 2:
                drawable = new Wave();
                break;
            case 3:
                drawable = new WanderingCubes();
                break;
            case 4:
                drawable = new Pulse();
                break;
            case 5:
                drawable = new ChasingDots();
                drawable.setColor(ContextCompat.getColor(this, R.color.colorAccent));
                break;
            case 6:
                drawable = new ThreeBounce();
                break;
            case 7:
                drawable = new Circle();
                break;
            case 8:
                drawable = new CubeGrid();
                break;
            case 9:
                drawable = new FadingCircle();
                break;
            case 10:
                drawable = new FoldingCube();
                break;
        }
        mSpinKitView.setIndeterminateDrawable(drawable);
    }

    @Override
    protected void initData() {
    }
}
