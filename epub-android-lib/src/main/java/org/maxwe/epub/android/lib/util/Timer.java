package org.maxwe.epub.android.lib.util;

/**
 * Created by Pengwei Ding on 2016-02-29 16:00.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class Timer {
    /**
     * 初始化整个阅读器View对象
     */
    public static long initEPubContainerStart;
    public static long initEPubContainerEnd;


    /**
     * 后台线程程配置图书
     */
    public static long configureStart;
    public static long configureEnd;

    /**
     * 后台线程解压图书
     */
    public static long unzipStart;
    public static long unzipEnd;


    /**
     * 后台线程排版章节
     */
    public static long typesetterChapterStart;
    public static long typesetterChapterEnd;
}
