package org.maxwe.epub.android.lib.core.data;

import org.maxwe.epub.android.lib.core.model.IBook;

/**
 * Created by Pengwei Ding on 2016-02-17 15:36.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 关于图书的数据库操作接口
 */
public interface IBookData<E extends IBook> {

    E findBookById(String bookId) throws Exception;

    E saveBook(E e) throws Exception;

    E updateBook(E e) throws Exception;

    E deleteBook(E e) throws Exception;

}
