package com.lance.perfect.view.activity;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import com.lance.perfect.R;
import com.lance.perfect.view.activity.base.BaseActivity;
import com.lance.perfect.view.widget.TitleBarView;

import java.io.File;

/**
 * 作用:  UCrop剪切图片展示页
 * 作者： 张甲彪
 * 时间： 2016/5/27.
 */
public class UCropResultActivity extends BaseActivity{
    private TitleBarView mTitleBarView;
    private ImageView mImageView;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_ucrop_result;
    }
    @Override
    protected void initViews() {
        mTitleBarView= (TitleBarView) findViewById(R.id.mTitleBarView);
        mImageView= (ImageView) findViewById(R.id.mImageView);
        mImageView.setImageURI(getIntent().getData());
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(new File(getIntent().getData().getPath()).getAbsolutePath(), options);
        mTitleBarView.setTitleBar(View.VISIBLE, View.VISIBLE, View.GONE,
                getString(R.string.format_crop_result_d_d, options.outWidth, options.outHeight),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                },null);
    }
    @Override
    protected void initData() {

    }
}
