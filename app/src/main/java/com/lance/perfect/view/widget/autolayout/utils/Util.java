package com.lance.perfect.view.widget.autolayout.utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.JsonToken;
import android.util.Log;
import android.widget.ImageView;
/**
 * 图片获取等处理问�?
 */
public class Util {
	/**
	 * 判断是否为空
	 * @param json字符�?
	 * @return
	 */
	public static boolean isJson(String json) {
		if (json != null && !json.equals("[]") && !json.trim().equals("")) {
			return true;
		}
		return false;
	}
	/**
	 * 把图片画成圆�?
	 * @param bitmap图片
	 * @return
	 */
	public static Bitmap GetRoundedCornerBitmap(Bitmap bitmap) {
	    try {
	        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
	                bitmap.getHeight(), Config.ARGB_8888);
	        Canvas canvas = new Canvas(output);                
	        final Paint paint = new Paint();
	        final Rect rect = new Rect(0, 0, bitmap.getWidth(),
	                bitmap.getHeight());       
	        final RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(),
	                bitmap.getHeight()));
	        final float roundPx = 14;
	        paint.setAntiAlias(true);
	        canvas.drawARGB(0, 0, 0, 0);
	        paint.setColor(Color.BLACK);       
	        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
	        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));            
	 
	        final Rect src = new Rect(0, 0, bitmap.getWidth(),
	                bitmap.getHeight());
	         
	        canvas.drawBitmap(bitmap, src, rect, paint);   
	        return output;
	    } catch (Exception e) {        
	        return bitmap;
	    }
	}
 
	/**
	 * 把网络图片转成bitmap
	 * @param path路径
	 * @return
	 */
	public static Bitmap getBitmapImg(String path){
		Bitmap bitmap = null;
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			if(conn.getResponseCode() == 200){
	//			Log.i("song", "toux");
				InputStream is = conn.getInputStream();
				bitmap = BitmapFactory.decodeStream(is);
			}
		} catch (Exception e) {
			bitmap = null;
			e.printStackTrace();
		}
		return bitmap;
	}
	/**
	 * 判断sd卡是否存在，不存在返回fasle
	 * @return
	 */
	public static boolean existSD(){
		String sdStatus = Environment.getExternalStorageState();
		if(sdStatus.equals(Environment.MEDIA_MOUNTED)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 获取�?
	 * @param activity
	 * @return
	 */
	public static int getscreenHight(Activity activity){
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.heightPixels;
	}
	/**
	 * 获取�?
	 * @param activity
	 * @return
	 */
	public static int getscreenWidth(Activity activity){
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		return dm.widthPixels;
	}
	/**
	 * 获取版本
	 * @param context
	 * @return
	 */
	public static String getVersionCode(Context context){
		String versionStr = "";
		String pkName = context.getPackageName();
		try {
			versionStr = String.valueOf(context.getPackageManager().getPackageInfo(pkName, 0).versionCode);
		} catch (Exception e) {
			versionStr = "1";
			e.printStackTrace();
		}
		return versionStr;
	}
	public static Drawable getDrawable(Context context,int resid){
		return context.getResources().getDrawable(resid);
	}
}
