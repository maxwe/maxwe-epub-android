package org.maxwe.epub.android.lib.core.model;

/**
 * Created by Pengwei Ding on 2016-02-12 12:34.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 阅读进度接口规范
 */
public interface IProgress {

    String getUserId();

    String getBookId();

    int getChapterOffset();

    int getParagraphOffset();

    int getSectionOffset();

    int getMetaOffset();
}
