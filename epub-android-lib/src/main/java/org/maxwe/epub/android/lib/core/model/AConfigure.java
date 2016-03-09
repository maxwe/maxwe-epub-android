package org.maxwe.epub.android.lib.core.model;

import org.maxwe.epub.typesetter.core.IConfigure;

/**
 * Created by Pengwei Ding on 2016-02-12 12:34.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 阅读配置接口规范
 */
public abstract class AConfigure implements IConfigure {
    private int startX = 100;
    private int startY = 100;
    private int endX = 1440 - 100;
    private int endY = 2304 - 100;
    private String fontStyle;
    private int fontSize = 25;
    private int fontSpace = 2;
    private int lineSpace = 25;
    private int pageMargin = 25;

    @Override
    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    @Override
    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    @Override
    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    @Override
    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    @Override
    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    @Override
    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public int getFontSpace() {
        return fontSpace;
    }

    public void setFontSpace(int fontSpace) {
        this.fontSpace = fontSpace;
    }

    @Override
    public int getLineSpace() {
        return lineSpace;
    }

    public void setLineSpace(int lineSpace) {
        this.lineSpace = lineSpace;
    }

    @Override
    public int getPageMargin() {
        return pageMargin;
    }

    public void setPageMargin(int pageMargin) {
        this.pageMargin = pageMargin;
    }

    public abstract String getUserId();

    public abstract String getBookId();
}
