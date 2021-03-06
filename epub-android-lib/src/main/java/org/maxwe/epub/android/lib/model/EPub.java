package org.maxwe.epub.android.lib.model;


import org.maxwe.epub.android.lib.core.model.IBook;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Pengwei Ding on 2016-02-10 14:41.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
@Table(name = "EPub")
public class EPub implements IBook{

    @Column(name = "bookId",isId = true)
    private String bookId;
    @Column(name = "bookPath")
    private String bookPath;
    @Column(name = "bookDir")
    private String bookDir;
    @Column(name = "bookName")
    private String bookName;
    @Column(name = "coverPath")
    private String coverPath;
    @Column(name = "bookVersion")
    private String bookVersion;
    @Column(name = "isUnziped")
    private boolean isUnziped;
    @Column(name = "isTableed")
    private boolean isTableed;

    public EPub(){}

    public EPub(String bookId,String bookPath){
        this.bookId = bookId;
        this.bookPath = bookPath;
    }

    @Override
    public String getBookId() {
        return this.bookId;
    }

    @Override
    public String getBookPath() {
        return this.bookPath;
    }

    @Override
    public String getBookDir() {
        return this.bookDir;
    }

    @Override
    public String getCoverPath() {
        return this.coverPath;
    }

    @Override
    public String getBookName() {
        return this.bookName;
    }

    @Override
    public String getBookVersion() {
        return this.bookVersion;
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
