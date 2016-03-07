package org.maxwe.epub.android.lib.core.model;

import org.maxwe.epub.typesetter.core.IConfigure;

/**
 * Created by Pengwei Ding on 2016-02-12 12:34.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 阅读配置接口规范
 */
public abstract class AConfigure implements IConfigure {

    @Override
    public String getFontStyle() {
        return null;
    }

    @Override
    public int getFontSize() {
        return 0;
    }

    @Override
    public int getFontSpace() {
        return 0;
    }

    @Override
    public int getLineSpace() {
        return 0;
    }

    @Override
    public int getPageMargin() {
        return 0;
    }

    @Override
    public int getChapterIndex() {
        return 0;
    }

    @Override
    public int getParagraphIndex() {
        return 0;
    }

    @Override
    public int getSectionIndex() {
        return 0;
    }

    @Override
    public int getMetaIndex() {
        return 0;
    }

    public abstract String getUserId();

    public abstract String getBookId();
}
