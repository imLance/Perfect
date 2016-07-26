package com.lance.perfect.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

public class GlideSingleRoundTransform extends BitmapTransformation {

	private static float bLeft=0f;
	private static float bRight=0f;
	private static float bTop=0f;
	private static float bBottom=0f;
	/**
	 * 
	 */
	public GlideSingleRoundTransform(Context context) {
		super(context);
	}

	public GlideSingleRoundTransform(Context context, int dleft,int dright,int dtop,int dbottom) {
		super(context);
		this.bLeft = Resources.getSystem().getDisplayMetrics().density * dleft;
		this.bRight = Resources.getSystem().getDisplayMetrics().density * dright;
		this.bTop = Resources.getSystem().getDisplayMetrics().density * dtop;
		this.bBottom = Resources.getSystem().getDisplayMetrics().density * dbottom;
	}
	
	
	@Override
	protected Bitmap transform(BitmapPool pool, Bitmap toTransform,
			int outWidth, int outHeight) {
		return roundCrop(pool, toTransform);
	}

	private static Bitmap roundCrop(BitmapPool pool, Bitmap source) {
		if (source == null)
			return null;

		Bitmap result = pool.get(source.getWidth(), source.getHeight(),
				Bitmap.Config.ARGB_8888);
		if (result == null) {
			result = Bitmap.createBitmap(source.getWidth(), source.getHeight(),
					Bitmap.Config.ARGB_8888);
		}

		Canvas canvas = new Canvas(result);
		Paint paint = new Paint();
		paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP,
				BitmapShader.TileMode.CLAMP));
		paint.setAntiAlias(true);
		RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
		Path path=new Path();
		float[] radii={bLeft,bLeft,bRight,bRight,bTop,bTop,bBottom,bBottom};
		path.addRoundRect(rectF, radii, Path.Direction.CW);
		canvas.drawPath(path,paint);
		return result;
	}


	@Override
	public String getId() {
		return getClass().getName() + Math.round(bLeft);
	}

}
