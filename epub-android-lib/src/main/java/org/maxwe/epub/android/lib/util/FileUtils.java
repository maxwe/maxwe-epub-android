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
        ZipInputStream inZip = new ZipInputStream(new FileInputStream(zipPath));
        ZipEntry zipEntry;
        String fileName;
        while ((zipEntry = inZip.getNextEntry()) != null) {
            byte[] buffer = new byte[1024 * 1024 * 5];
            inZip.read(buffer);
            fileName = zipEntry.getName();
            if (zipEntry.isDirectory()) {
                fileName = fileName.substring(0, fileName.length() - 1);
                File folder = new File(targetDirPath + File.separator + fileName);
                folder.mkdirs();
            } else {
                File file = new File(targetDirPath + File.separator + fileName);
                file.createNewFile();
                FileOutputStream out = new FileOutputStream(file);
                int len;
                byte[] bytes = new byte[1024 * 1024 * 5];
                while ((len = inZip.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                    out.flush();
                }
                out.close();
            }
        }
        inZip.close();
    }

    public static void UnZipFolder2(String zipFileString, String outPathString) throws Exception {
        if (!outPathString.endsWith(File.separator)) {
            outPathString = outPathString + File.separator;
        }
        File pathFile = new File(outPathString);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        ZipFile zip = new ZipFile(zipFileString);
        for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (outPathString + zipEntryName).replaceAll("\\*", "/");
            //判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if (!file.exists()) {
                file.mkdirs();
            }
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isDirectory()) {
                continue;
            }

            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024 * 1024 * 5];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
    }

}
