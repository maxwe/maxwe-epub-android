package org.maxwe.epub.android.lib.data;

import android.content.Context;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;

import org.maxwe.epub.android.lib.core.data.IContentData;
import org.maxwe.epub.android.lib.model.Content;

import java.util.List;

/**
 * Created by Pengwei Ding on 2016-02-17 17:23.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class ContentData implements IContentData {

    @Override
    public List<Content> getContentsByBookId(Context context, String bookId) {
        DbUtils db = Data.getDB(context);
        List<Content> result = null;
        try {
            result = db.findAll(Selector.from(Content.class).where("bookId", "=", bookId));
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

    @Override
    public List<Content> getContentsByBookId(Context context, String bookId, int page, int limit) {
        DbUtils db = Data.getDB(context);
        List<Content> result = null;
        try {
            result = db.findAll(Selector.from(Content.class).where("bookId", "=", bookId).limit(limit).offset(page * limit));
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }

    @Override
    public List<Content> saveContents(Context context, List list) {
        DbUtils db = Data.getDB(context);
        try {
            db.saveBindingIdAll(list);
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return list;
    }

    @Override
    public List<Content> updateContents(Context context, List list) {
        DbUtils db = Data.getDB(context);
        try {
            db.saveOrUpdateAll(list);
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return list;
    }

    @Override
    public List<Content> deleteContentsByBookId(Context context, String bookId) {
        DbUtils db = Data.getDB(context);
        List<Content> result = null;
        try {
            result = db.findAll(Selector.from(Content.class).where("bookId", "=", bookId));
            db.delete(Content.class, WhereBuilder.b("bookId", "=", bookId));
        } catch (DbException e) {
            e.printStackTrace();
        } finally {

        }
        return result;
    }
}
