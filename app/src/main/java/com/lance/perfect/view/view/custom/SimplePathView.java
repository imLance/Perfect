package com.lance.perfect.view.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/6/1.
 */
public class SimplePathView extends View{
    private Paint mPaint;
    public SimplePathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);           // 画笔颜色 - 黑色
        mPaint.setStyle(Paint.Style.STROKE);    // 填充模式 - 描边
        mPaint.setStrokeWidth(10);              // 边框宽度 - 10
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth()/2,getHeight()/2);
        Path mPath=new Path();
        mPath.addRect(-100,-100,100,100,Path.Direction.CCW);
        canvas.drawPath(mPath,mPaint);
    }
}
