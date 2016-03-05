package org.maxwe.epub.android.lib;

import org.maxwe.epub.android.lib.core.model.IProgress;

/**
 * Created by Pengwei Ding on 2016-01-05 17:27.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: EPub渲染器的初始化配置
 */
public class EPubRenderConfigure {
    private int chapterOffset;
    private int paragraphOffset;
    private int sectionOffset;
    private int metaOffset;
    private int pageIndex;

    public EPubRenderConfigure() {
        super();
    }

    public EPubRenderConfigure(int chapterOffset, int paragraphOffset, int sectionOffset, int metaOffset) {
        this.chapterOffset = chapterOffset;
        this.paragraphOffset = paragraphOffset;
        this.sectionOffset = sectionOffset;
        this.metaOffset = metaOffset;
    }

    public EPubRenderConfigure(IProgress progress) {
        this.chapterOffset = progress.getChapterOffset();
        this.paragraphOffset = progress.getParagraphOffset();
        this.sectionOffset = progress.getSectionOffset();
        this.metaOffset = progress.getMetaOffset();
    }

    public int getChapterOffset() {
        return chapterOffset;
    }

    public void setChapterOffset(int chapterOffset) {
        this.chapterOffset = chapterOffset;
    }

    public int getParagraphOffset() {
        return paragraphOffset;
    }

    public void setParagraphOffset(int paragraphOffset) {
        this.paragraphOffset = paragraphOffset;
    }

    public int getSectionOffset() {
        return sectionOffset;
    }

    public void setSectionOffset(int sectionOffset) {
        this.sectionOffset = sectionOffset;
    }

    public int getMetaOffset() {
        return metaOffset;
    }

    public void setMetaOffset(int metaOffset) {
        this.metaOffset = metaOffset;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}