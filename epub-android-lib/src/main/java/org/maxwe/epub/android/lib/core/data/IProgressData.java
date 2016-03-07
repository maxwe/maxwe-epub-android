package org.maxwe.epub.android.lib.core.data;

import org.maxwe.epub.android.lib.core.model.AConfigure;

/**
 * Created by Pengwei Ding on 2016-03-04 16:04.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 阅读进度数据
 * 图书的阅读进度保存，更新和删除
 */
public interface IProgressData {
    /**
     * 查找用户名下某一本图书的阅读进度
     * @param userId
     * @param bookId
     * @return
     * @throws Exception
     */
    AConfigure getProgress(String userId,String bookId) throws Exception;

    /**
     * 保存图书阅读进度
     * @param progress
     * @throws Exception
     */
    void saveProgress(AConfigure progress) throws Exception;
}
