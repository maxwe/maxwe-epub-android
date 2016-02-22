package org.maxwe.epub.android.lib.data;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * Created by Pengwei Ding on 2016-02-17 16:34.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 数据库操作方法
 */
public class Data {
    private static final String DB_NAME = "OrgMaxWeEPubLib.db";
    private static final String DB_DIR = "/mnt/sdcard/YMEPub/";
    private static final int DB_VERSION = 1;
    private static DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()

            .setDbDir(new File(DB_DIR))// 不设置dbDir时, 默认存储在app的私有目录.
            .setDbName(DB_NAME)
            .setDbVersion(DB_VERSION)
            .setDbOpenListener(new DbManager.DbOpenListener() {
                @Override
                public void onDbOpened(DbManager db) {
                    // 开启WAL, 对写入加速提升巨大
                    db.getDatabase().enableWriteAheadLogging();
                }
            })
            .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                @Override
                public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                    // TODO: ...
                    // db.addColumn(...);
                    // db.dropTable(...);
                    // ...
                    // or
                    // db.dropDb();
                }
            });

    /**
     * 数据库名常量
     */

    public static DbManager getDB() {
        return x.getDb(daoConfig);
    }
}
