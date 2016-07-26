package com.lance.perfect.view.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/6/1.
 */
public class SuperLoadingView extends View{
    /**当前进度*/
    private int progress=0;
    /**进度最大值*/
    private static final int MAX_PROGRESS=100;
    /**起始角度*/
    private static final int startAngle=-90;

    /**View的宽和高*/
    private int mWidth,mHeight;
    /**半径*/
    private int radius=0;
    /**画笔宽度*/
    private int strokeWidth=20;
    private RectF mRectF = new RectF();

    private Paint circlePaint;

    public SuperLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        circlePaint=new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.argb(255, 48, 63, 159));
        circlePaint.setStrokeWidth(strokeWidth);
        circlePaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;mHeight=h;
        radius=Math.min(getMeasuredWidth(),getMeasuredHeight())/4+strokeWidth;
        mRectF.set(new RectF(radius+strokeWidth, radius+strokeWidth,
                3 * radius+strokeWidth, 3 * radius+strokeWidth));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float percent = 1.0f*progress/MAX_PROGRESS;
        canvas.drawArc(mRectF,startAngle-270*percent,-(60+percent*300),false,circlePaint);
    }
    public void setProgress(int progress){
        this.progress=Math.min(progress,MAX_PROGRESS);
        postInvalidate();
    }
}
