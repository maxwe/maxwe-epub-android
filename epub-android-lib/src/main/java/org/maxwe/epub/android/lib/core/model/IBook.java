package org.maxwe.epub.android.lib.core.model;

/**
 * Created by Pengwei Ding on 2016-02-10 14:30.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 图书接口规范
 */
public interface IBook {
    
    String getBookId();

    String getBookPath();

    String getBookDir();

    String getCoverPath();

    String getBookName();

    boolean isUnziped();

    boolean isTableed();

    String getBookVersion();
}
