package com.lance.perfect.domain.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by tangqi on 10/7/15.
 */
public class DeviceUtils {
    public static List<String> getDeviceMsg(Context mContext) {
        List<String> deviceInfo = new ArrayList<>();
        PackageManager manager = mContext.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (info != null) {
            deviceInfo.add("=====\t设备信息\t=====");
            deviceInfo.add("硬件制造商 :" + Build.MANUFACTURER);
            deviceInfo.add("手机制造商:" + Build.PRODUCT);
            deviceInfo.add("手机型号:" + Build.MODEL);
            deviceInfo.add("Android版本号:" + Build.VERSION.RELEASE);
            deviceInfo.add("手机系统版本:" + Build.DISPLAY);
            deviceInfo.add("=====\t版本信息\t=====");
            deviceInfo.add("App版本号:" + info.versionCode + "");
            deviceInfo.add("应用版本号:" + info.versionName);
            deviceInfo.add("报错时间:" + new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss秒", Locale.CHINA).format(info.lastUpdateTime));
        }
        return deviceInfo;
    }
}
