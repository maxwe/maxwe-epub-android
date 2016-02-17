package org.maxwe.epub.android.lib.data;

import android.content.Context;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import org.maxwe.epub.android.lib.core.data.IBookData;
import org.maxwe.epub.android.lib.core.model.IBook;
import org.maxwe.epub.android.lib.model.EPub;

/**
 * Created by Pengwei Ding on 2016-02-17 16:29.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 图书数据操作
 */
public class EPubData implements IBookData {

    @Override
    public EPub findBookById(Context context, String bookId) {
        DbUtils db = Data.getDB(context);
        EPub ePubInDB = null;
        try {
            ePubInDB = db.findById(EPub.class, bookId);
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return ePubInDB;
    }

    @Override
    public EPub saveBook(Context context, IBook book) {
        DbUtils db = Data.getDB(context);
        try {
            db.replace(book);
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return (EPub)book;
    }

    @Override
    public EPub updateBook(Context context, IBook book) {
        DbUtils db = Data.getDB(context);
        try {
            db.saveOrUpdate(book);
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return (EPub)book;
    }

    @Override
    public EPub deleteBook(Context context, IBook book) {
        DbUtils db = Data.getDB(context);
        try {
            db.delete(book);
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return (EPub)book;
    }
}
