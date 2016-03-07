package org.maxwe.epub.android.lib.model;

import org.maxwe.epub.android.lib.core.model.AConfigure;
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
public class Progress extends AConfigure {

    @Column(name = "id",isId = true)
    private int id;
    @Column(name = "userId")
    private String userId;
    @Column(name = "bookId")
    private String bookId;
    /**
     * 已经阅读到的章节位置
     */
    @Column(name = "chapterIndex")
    protected int chapterIndex;
    /**
     * 已经阅读到的段落位置
     */
    @Column(name = "paragraphIndex")
    protected int paragraphIndex;
    /**
     * 已经阅读到的片段位置
     */
    @Column(name = "sectionIndex")
    protected int sectionIndex;
    /**
     * 已经阅读到的元素位置
     */
    @Column(name = "metaIndex")
    protected int metaIndex;

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

    @Override
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public int getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(int chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    @Override
    public int getParagraphIndex() {
        return paragraphIndex;
    }

    public void setParagraphIndex(int paragraphIndex) {
        this.paragraphIndex = paragraphIndex;
    }

    @Override
    public int getSectionIndex() {
        return sectionIndex;
    }

    public void setSectionIndex(int sectionIndex) {
        this.sectionIndex = sectionIndex;
    }

    @Override
    public int getMetaIndex() {
        return metaIndex;
    }

    public void setMetaIndex(int metaIndex) {
        this.metaIndex = metaIndex;
    }
}
