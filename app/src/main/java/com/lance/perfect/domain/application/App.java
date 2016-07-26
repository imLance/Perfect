package com.lance.perfect.domain.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lance.greendaodem.DaoMaster;
import com.lance.greendaodem.DaoSession;
import com.lance.perfect.domain.util.CrashCatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用:  TODO
 * 作者： 张甲彪
 * 时间： 2016/4/28.
 */
public class App extends Application{
    private static Context mContext;
    private static List<Activity> mActivities = new ArrayList<>();

    /***GreenDao数据库*/
    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        initGreenDaoData();
        CrashCatcher crashCatcher = CrashCatcher.newInstance();
        crashCatcher.setDefaultCrashCatcher();
    }
    /**
     * 初始化GreenDao数据库
     */
    private void initGreenDaoData() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        helper = new DaoMaster.DevOpenHelper(this, "note", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return daoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }
    public static Context getContext() {
        return mContext;
    }
    public static void addActivity(Activity activity) {
        mActivities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        mActivities.remove(activity);
    }

    public static void exitAll() {
        for (Activity activity : mActivities) {
            activity.finish();
        }
        System.exit(0);
    }
}
