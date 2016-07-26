package com.lance.perfect.view.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.lance.perfect.R;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/5/31.
 */
public class CircleView extends View{
    int mColor=Color.RED;
    private Paint mPaint;
    /***
     *  直接new 时用到
     * @param context
     */
    public CircleView(Context context) {
        super(context);
        init();
    }

    /**
     * xml用到
     * @param context
     * @param attrs
     */
    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //自定义颜色属性
        TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mColor=a.getColor(R.styleable.CircleView_circle_color,Color.RED);
        a.recycle();
        init();
    }

    private void init() {
        mPaint=new Paint();
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft=getPaddingLeft();
        int paddingRight=getPaddingRight();
        int paddingTop=getPaddingTop();
        int paddingBottom=getPaddingBottom();
        int width=getWidth()-paddingLeft-paddingRight;
        int height=getHeight()-paddingBottom-paddingTop;
        int radio=Math.min(width,height)/2;
        canvas.drawCircle(paddingLeft+width/2,paddingTop+height/2,radio,mPaint);
    }
}
