package com.lance.perfect.view.widget.pullToRefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lance.perfect.R;

/**
 * Simple RecyclerView Divider
 * Created by tangqi on 9/16/15.
 */
public class RecyclerViewItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;

    public RecyclerViewItemDecoration(Context context) {
        if (false)
            mDivider = context.getResources().getDrawable(R.drawable.item_divider_white);
        else mDivider = context.getResources().getDrawable(R.drawable.item_divider_black);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}
