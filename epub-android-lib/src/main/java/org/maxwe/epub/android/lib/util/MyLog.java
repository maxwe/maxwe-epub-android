package org.maxwe.epub.android.lib.util;

import java.util.LinkedList;

/**
 * Created by Pengwei Ding on 2016-02-29 15:37.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class MyLog {
    private static final MyLog myLog = new MyLog();
    private static boolean FIX_PRINTABLE = true;
    private static boolean PRINTABLE = true;
    private static final  LinkedList<String> classNames = new LinkedList<>();

    public static MyLog setPrintable(boolean printable){
        PRINTABLE = printable;
        return myLog;
    }

    public static MyLog addLogAccess(Class Class){
        if (!classNames.contains(Class.getName())){
            classNames.add(Class.getName());
        }
        return myLog;
    }

    public static MyLog removeLogAccess(Class Class){
        classNames.remove(Class.getName());
        return myLog;
    }

    public static MyLog clearLogAccess(){
        classNames.clear();
        return myLog;
    }

    public static MyLog print(Class Class,String message){
        if (FIX_PRINTABLE && PRINTABLE && classNames.contains(Class.getName())){
            System.out.println(message);
        }
        return myLog;
    }
}
