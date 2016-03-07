package org.maxwe.epub.android.lib.data;

import android.content.Context;

import org.maxwe.epub.android.lib.core.data.IContentData;
import org.maxwe.epub.android.lib.core.model.IContent;
import org.maxwe.epub.android.lib.model.Content;
import org.xutils.DbManager;
import org.xutils.db.sqlite.WhereBuilder;

import java.util.List;

/**
 * Created by Pengwei Ding on 2016-02-17 17:23.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class ContentData implements IContentData {

    @Override
    public List<Content> getContentsByBookId(String bookId) throws Exception {
        DbManager db = Data.getDB();
        return db.selector(Content.class).where("bookId", "=", bookId).findAll();
    }

    @Override
    public List<Content> getContentsByBookId(String bookId, int page, int limit) throws Exception {
        DbManager db = Data.getDB();
        return db.selector(Content.class).where("bookId", "=", bookId).limit(limit).offset(page * limit).findAll();
    }

    @Override
    public List<Content> saveContents( List list) throws Exception {
        DbManager db = Data.getDB();
        db.saveBindingId(list);
        return list;
    }

    @Override
    public List<Content> updateContents(List list) throws Exception {
        DbManager db = Data.getDB();
        db.saveOrUpdate(list);
        return list;
    }

    @Override
    public List<Content> deleteContentsByBookId(String bookId) throws Exception {
        DbManager db = Data.getDB();
        List<Content> result = db.selector(Content.class).where("bookId", "=", bookId).findAll();
        db.delete(Content.class, WhereBuilder.b("bookId", "=", bookId));
        return result;
    }

    @Override
    public IContent getContent(String bookId, int index) throws Exception {
        return null;
    }
}
