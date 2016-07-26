package com.lance.perfect.domain.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lance.perfect.R;
import com.lance.perfect.view.widget.GlideCircleTransform;
import com.lance.perfect.view.widget.GlideRoundTransform;

/**
 * 作用:  图片加载类
 * 作者： 张甲彪
 * 时间： 2016/5/24.
 */
public class GlideUtils {
    /***
     * 加载图片
     * @param mContext
     * @param url
     * @param mImageView
     */
    public static void loadImage(Context mContext, String url, ImageView mImageView){
        try {
            Glide.with(mContext).load(url)
                    .placeholder(R.drawable.w_glide_normal_loading)
                    .error(R.drawable.w_glide_normal_fail)
                    .into(mImageView);
        } catch (Exception e) {
        }
    }
    /***
     * 加载圆角图片
     * @param mContext
     * @param url
     * @param mImageView
     */
    public static void loadRoundImage(Context mContext,String url,ImageView mImageView,int radio){
        try {
            Glide.with(mContext).load(url)
                    .placeholder(R.drawable.w_glide_round_loading) //load_logo
                    .error(R.drawable.w_glide_round_fail)
			.transform(new GlideRoundTransform(mContext, radio))
                    .into(mImageView);
        } catch (Exception e) {
        }
    }
    /**
     * 加载圆形图片
     * @param mContext
     * @param url
     * @param mImageView
     */
    public static void loadCircleImage(Context mContext,String url,ImageView mImageView){
        try {
            Glide.with(mContext).load(url)
                    .placeholder(R.drawable.w_glide_round_loading) //w_spxq_bg_logo
                    .error(R.drawable.w_glide_round_fail)
                    .transform(new GlideCircleTransform(mContext))
                    .into(mImageView);
        } catch (Exception e) {
        }
    }

    /**
     * 加载本地图片
     * @param mContext
     * @param resId
     * @param mImageView
     */
    public static void loadLocalImage(Context mContext,int resId,ImageView mImageView){
        try {
        Glide.with(mContext).load(resId)
                .placeholder(R.drawable.w_glide_round_loading) //w_spxq_bg_logo
                .error(R.drawable.w_glide_round_fail)
                .into(mImageView);
        } catch (Exception e) {
        }
    }
}
