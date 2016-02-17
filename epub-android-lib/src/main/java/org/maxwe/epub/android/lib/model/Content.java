package org.maxwe.epub.android.lib.model;

import org.maxwe.epub.android.lib.core.model.IContent;

/**
 * Created by Pengwei Ding on 2016-02-12 12:50.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Content implements IContent{

    private String bookId;
    private int order;
    private int level;
    private String displayName;
    private String status;
    private String url;

    @Override
    public String getBookId() {
        return bookId;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setOrder(int order) {
        this.order = order;
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
}
