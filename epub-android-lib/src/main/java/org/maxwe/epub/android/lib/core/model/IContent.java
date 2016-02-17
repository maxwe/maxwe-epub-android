package org.maxwe.epub.android.lib.core.model;

/**
 * Created by Pengwei Ding on 2016-02-10 15:21.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 目录接口规范
 */
public interface IContent {
    String CONTENT_STATUS_UNREAD = "unread";
    String CONTENT_STATUS_READING = "reading";
    String CONTENT_STATUS_READ = "read";

    String getBookId();

    int getOrder();
    int getLevel();

    String getDisplayName();
    String getStatus();
    String getUrl();
}
