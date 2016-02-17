package org.maxwe.epub.android.lib.data;

import android.content.Context;

import com.lidroid.xutils.DbUtils;

/**
 * Created by Pengwei Ding on 2016-02-17 16:34.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 数据库操作方法
 */
public class Data {
    /**
     * 数据库名常量
     */
    private static final String DB_NAME = "OrgMaxWeEPubLib.db";
    public static DbUtils getDB(Context context) {
        return DbUtils.create(context, "/mnt/sdcard/YMEPub/", DB_NAME, 1, new DbUtils.DbUpgradeListener() {
            //        return DbUtils.create(context, DB_NAME, 1, new DbUtils.DbUpgradeListener() {
            @Override
            public void onUpgrade(DbUtils db, int oldVersion, int newVersion) {

            }
        });
    }
}
