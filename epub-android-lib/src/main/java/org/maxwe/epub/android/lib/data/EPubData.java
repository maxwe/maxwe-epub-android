package org.maxwe.epub.android.lib.data;

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
    public EPub findBookById(String bookId) throws Exception {
        return Data.getDB().findById(EPub.class, bookId);
    }

    @Override
    public EPub saveBook(IBook book) throws Exception {
        Data.getDB().replace(book);
        return (EPub)book;
    }

    @Override
    public EPub updateBook(IBook book) throws Exception {
        Data.getDB().saveOrUpdate(book);
        return (EPub)book;
    }

    @Override
    public EPub deleteBook(IBook book) throws Exception{
        Data.getDB().delete(book);
        return (EPub)book;
    }
}
