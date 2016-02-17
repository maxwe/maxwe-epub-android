package org.maxwe.epub.android.lib.core.data;

import android.content.Context;

import org.maxwe.epub.android.lib.core.model.IBook;

/**
 * Created by Pengwei Ding on 2016-02-17 15:36.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 关于图书的数据库操作接口
 */
public interface IBookData<E extends IBook> {

    E findBookById(Context context,String bookId);
    E saveBook(Context context,E e);
    E updateBook(Context context,E e);
    E deleteBook(Context context,E e);

}
