package org.maxwe.epub.android.lib.data;

import android.content.Context;

import org.maxwe.epub.android.lib.core.data.IContentData;
import org.maxwe.epub.android.lib.model.Content;
import org.xutils.DbManager;
import org.xutils.db.Selector;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;

import java.util.List;

/**
 * Created by Pengwei Ding on 2016-02-17 17:23.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class ContentData implements IContentData {

    @Override
    public List<Content> getContentsByBookId(Context context, String bookId) {
        DbManager db = Data.getDB();
        List<Content> result = null;
        try {
            result = db.selector(Content.class).where("bookId", "=", bookId).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

    @Override
    public List<Content> getContentsByBookId(Context context, String bookId, int page, int limit) {
        DbManager db = Data.getDB();
        List<Content> result = null;
        try {
            result = db.selector(Content.class).where("bookId", "=", bookId).limit(limit).offset(page * limit).findAll();
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

    @Override
    public List<Content> saveContents(Context context, List list) {
        DbManager db = Data.getDB();
        try {
            db.saveBindingId(list);
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return list;
    }

    @Override
    public List<Content> updateContents(Context context, List list) {
        DbManager db = Data.getDB();
        try {
            db.saveOrUpdate(list);
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return list;
    }

    @Override
    public List<Content> deleteContentsByBookId(Context context, String bookId) {
        DbManager db = Data.getDB();
        List<Content> result = null;
        try {
            result = db.selector(Content.class).where("bookId", "=", bookId).findAll();
            db.delete(Content.class, WhereBuilder.b("bookId", "=", bookId));
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }
}
