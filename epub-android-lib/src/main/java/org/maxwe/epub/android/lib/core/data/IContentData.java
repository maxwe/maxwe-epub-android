package org.maxwe.epub.android.lib.core.data;

import android.content.Context;

import org.maxwe.epub.android.lib.core.model.IBook;
import org.maxwe.epub.android.lib.core.model.IContent;

import java.util.List;

/**
 * Created by Pengwei Ding on 2016-02-17 15:36.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 关于图书的目录数据库操作接口
 */
public interface IContentData<E extends IContent> {
    List<E> getContentsByBookId(String bookId) throws Exception;
    List<E> getContentsByBookId(String bookId,int page,int limit) throws Exception;
    List<E> saveContents(List<E> es) throws Exception;
    List<E> updateContents(List<E> es) throws Exception;
    List<E> deleteContentsByBookId(String bookId) throws Exception;
}
