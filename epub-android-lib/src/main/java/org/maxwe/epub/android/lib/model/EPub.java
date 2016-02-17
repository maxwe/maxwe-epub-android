package org.maxwe.epub.android.lib.model;

import org.maxwe.epub.android.lib.core.model.IBook;

/**
 * Created by Pengwei Ding on 2016-02-10 14:41.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class EPub implements IBook{

    private String bookId;
    private String bookPath;
    private String bookDir;
    private String bookName;
    private String coverPath;
    private String bookVersion;
    private boolean isUnziped;
    private boolean isTableed;

    public EPub(){}

    @Override
    public String getBookId() {
        return null;
    }

    @Override
    public String getBookPath() {
        return null;
    }

    @Override
    public String getBookDir() {
        return null;
    }

    @Override
    public String getCoverPath() {
        return null;
    }

    @Override
    public String getBookName() {
        return null;
    }

    @Override
    public String getBookVersion() {
        return null;
    }

    @Override
    public boolean isUnziped() {
        return isUnziped;
    }

    @Override
    public boolean isTableed() {
        return isTableed;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookPath(String bookPath) {
        this.bookPath = bookPath;
    }

    public void setBookDir(String bookDir) {
        this.bookDir = bookDir;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public void setBookVersion(String bookVersion) {
        this.bookVersion = bookVersion;
    }

    public void setIsUnziped(boolean isUnziped) {
        this.isUnziped = isUnziped;
    }

    public void setIsTableed(boolean isTableed) {
        this.isTableed = isTableed;
    }
}
