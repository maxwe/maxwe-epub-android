package org.maxwe.epub.android.lib.model;

import org.maxwe.epub.android.lib.core.model.IProgress;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Pengwei Ding on 2016-03-04 16:32.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 阅读进度
 * id作为数据库数据标记主键
 * (userId + bookId)作为业务逻辑主键
 */
@Table(name = "Progress")
public class Progress implements IProgress{
    @Column(name = "id",isId = true)
    private int id;
    @Column(name = "userId")
    private String userId;
    @Column(name = "bookId")
    private String bookId;
    @Column(name = "chapterOffset")
    private int chapterOffset;
    @Column(name = "paragraphOffset")
    private int paragraphOffset;
    @Column(name = "sectionOffset")
    private int sectionOffset;
    @Column(name = "metaOffset")
    private int metaOffset;

    public Progress() {
        super();
    }

    public Progress(String userId, String bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setChapterOffset(int chapterOffset) {
        this.chapterOffset = chapterOffset;
    }

    public void setParagraphOffset(int paragraphOffset) {
        this.paragraphOffset = paragraphOffset;
    }

    public void setSectionOffset(int sectionOffset) {
        this.sectionOffset = sectionOffset;
    }

    public void setMetaOffset(int metaOffset) {
        this.metaOffset = metaOffset;
    }

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public String getBookId() {
        return this.bookId;
    }

    @Override
    public int getChapterOffset() {
        return this.chapterOffset;
    }

    @Override
    public int getParagraphOffset() {
        return this.paragraphOffset;
    }

    @Override
    public int getSectionOffset() {
        return this.sectionOffset;
    }

    @Override
    public int getMetaOffset() {
        return this.metaOffset;
    }
}
