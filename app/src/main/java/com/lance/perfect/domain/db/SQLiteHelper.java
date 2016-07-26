package com.lance.perfect.domain.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lance.perfect.domain.application.App;

/**
 * 作用:  数据库操作
 * 作者： 张甲彪
 * 时间： 2016/4/28.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    public static int VERSION = 1;

    public static String DATABASE_NAME = "bb.db";

    public static String CREATE_DAILYGSON_TABLE = "CREATE TABLE daily("
            + "id SMALLINT PRIMARY KEY NOT NULL,"
            + "title TEXT NOT NULL,"
            + "type SMALLINT NOT NULL,"
            + "image_source TEXT NULL,"
            + "image TEXT NULL,"
            + "share_url TEXT NULL,"
            + "ga_prefix SMALLINT NULL,"
            + "body TEXT NULL,"
            + "UNIQUE (id))";

    public static String CREATE_DAILYRESULT_TABLE = "CREATE TABLE dailyresult("
            + "date SMALLINT,"
            + "id SMALLINT PRIMARY KEY,"
            + "title TEXT,"
            + "image TEXT NULL,"
            + "type SMALLINT,"
            + "ga_prefix SMALLINT,"
            + "UNIQUE (id))";

    public SQLiteHelper() {
        super(App.getContext(), DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DAILYGSON_TABLE);
        db.execSQL(CREATE_DAILYRESULT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
