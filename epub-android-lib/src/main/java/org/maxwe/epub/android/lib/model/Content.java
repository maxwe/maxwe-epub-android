package org.maxwe.epub.android.lib.model;

import org.maxwe.epub.android.lib.core.model.IContent;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Pengwei Ding on 2016-02-12 12:50.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
@Table(name = "Content")
public class Content implements IContent{

    @Column(name = "id",isId = true)
    private int id;
    private String bookId;
    private int orderIndex;
    private int level;
    private String displayName;
    private String status;
    private String url;

    public Content() {
        super();
    }

    public Content(String bookId, String displayName,String url) {
        this.bookId = bookId;
        this.displayName = displayName;
        this.url = url;
    }

    @Override
    public String getBookId() {
        return bookId;
    }

    @Override
    public int getOrderIndex() {
        return this.orderIndex;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
