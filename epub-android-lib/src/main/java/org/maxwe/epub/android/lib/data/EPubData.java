package org.maxwe.epub.android.lib.data;

import android.content.Context;

import org.maxwe.epub.android.lib.core.data.IBookData;
import org.maxwe.epub.android.lib.core.model.IBook;
import org.maxwe.epub.android.lib.model.EPub;
import org.xutils.DbManager;
import org.xutils.ex.DbException;

/**
 * Created by Pengwei Ding on 2016-02-17 16:29.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 图书数据操作
 */
public class EPubData implements IBookData {

    @Override
    public EPub findBookById(Context context, String bookId) throws Exception {
        return Data.getDB().findById(EPub.class, bookId);
    }

    @Override
    public EPub saveBook(Context context, IBook book) throws Exception {
        Data.getDB().replace(book);
        return (EPub)book;
    }

    @Override
    public EPub updateBook(Context context, IBook book) throws Exception {
        Data.getDB().saveOrUpdate(book);
        return (EPub)book;
    }

    @Override
    public EPub deleteBook(Context context, IBook book) throws Exception{
        Data.getDB().delete(book);
        return (EPub)book;
    }
}
