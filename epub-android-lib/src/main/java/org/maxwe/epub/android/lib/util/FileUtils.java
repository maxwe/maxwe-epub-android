package org.maxwe.epub.android.lib.util;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by Pengwei Ding on 2016-02-18 09:47.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class FileUtils {

    public static void unzip(String zipPath, String targetDirPath) throws Exception{
        InputStream is = new FileInputStream(zipPath);
        String filename;
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(is));
        ZipEntry ze;
        byte[] buffer = new byte[1024 * 1024 * 5];
        int count;
        while ((ze = zis.getNextEntry()) != null) {
            filename = ze.getName();
            if (ze.isDirectory()) {
                File fmd = new File(targetDirPath, filename);
                fmd.mkdirs();
                continue;
            } else {
                File fmd = new File(targetDirPath, filename);
                String parent = fmd.getParentFile().getPath();
                File fmd_1 = new File(parent);
                fmd_1.mkdirs();
            }
            File file = new File(targetDirPath, filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while ((count = zis.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, count);
            }
            fileOutputStream.close();
            zis.closeEntry();
            String absolutePath = file.getAbsolutePath();
            System.out.println("解压：" + absolutePath);
        }
        zis.close();
    }
}
