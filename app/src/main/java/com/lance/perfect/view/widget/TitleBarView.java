package com.lance.perfect.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lance.perfect.R;
import com.lance.perfect.view.widget.autolayout.AutoRelativeLayout;

/**
 * 作用:  标题栏
 * 作者： 张甲彪
 * 时间： 2016/5/24.
 */
public class TitleBarView extends AutoRelativeLayout{
    public static final String TAG = "TitleBarView";
    private Context mContext;

    /**标题*/
    private TextView mTitleTV;
    /**返回布局*/
    private RelativeLayout mBackLayout;
    private ImageView mBackIV;
    /**更多布局*/
    private RelativeLayout mMoreLayout;
    private ImageView mMoreIV;
    public TitleBarView(Context context) {
        super(context);
        this.mContext=context;
        initView();
    }
    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        initView();
    }
    public TitleBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext=context;
        initView();
    }
    private void initView() {
        View view= LayoutInflater.from(mContext).inflate(R.layout.common_title_bar, this);
        mTitleTV= (TextView) view.findViewById(R.id.mTitleTV);
        mBackLayout= (RelativeLayout) view.findViewById(R.id.mBackLayout);
        mBackIV= (ImageView) view.findViewById(R.id.mBackIV);
        mMoreLayout= (RelativeLayout) view.findViewById(R.id.mMoreLayout);
        mMoreIV= (ImageView) view.findViewById(R.id.mMoreIV);
    }
    public void setTitleBar(int backIsVisible,int titleIsVisible,int moreIsVisible,
               String titleText,OnClickListener backListener,OnClickListener moreListener){
        mBackLayout.setVisibility(backIsVisible);
        mTitleTV.setVisibility(titleIsVisible);
        mMoreLayout.setVisibility(moreIsVisible);
        mTitleTV.setText(titleText);
        mBackLayout.setOnClickListener(backListener);
        mMoreLayout.setOnClickListener(moreListener);
    }
    public void setTitle(String titleText){
        mTitleTV.setText(titleText);
    }
}
