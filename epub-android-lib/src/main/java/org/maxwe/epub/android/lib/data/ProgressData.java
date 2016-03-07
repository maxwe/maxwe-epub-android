package org.maxwe.epub.android.lib.data;

import org.maxwe.epub.android.lib.core.data.IProgressData;
import org.maxwe.epub.android.lib.core.model.AConfigure;
import org.maxwe.epub.android.lib.model.Progress;
import org.xutils.DbManager;

/**
 * Created by Pengwei Ding on 2016-03-04 16:15.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 进度数据操作实现
 */
public class ProgressData implements IProgressData {

    @Override
    public AConfigure getProgress(String userId, String bookId) throws Exception {
        DbManager db = Data.getDB();
        Progress progressHistory = db.selector(Progress.class).where("userId", "is", userId).and("bookId", "is", bookId).findFirst();
        if (progressHistory == null){
            db.saveBindingId(new Progress(userId, bookId));
            progressHistory = db.selector(Progress.class).where("userId", "is", userId).and("bookId", "is", bookId).findFirst();
        }
        return progressHistory;
    }

    @Override
    public void saveProgress(AConfigure progress) throws Exception {
        DbManager db = Data.getDB();
        db.update(progress,"chapterOffset","paragraphOffset","sectionOffset","metaOffset");
    }
}
