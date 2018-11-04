package com.wsh.io.copydir;

import com.wsh.io.copyfile.CopyFileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Description: 拷贝文件夹工具类
 * @Author: weishihuai
 * @Date: 2018/10/26 21:38
 */
public class CopyDirUtils {

    public static void copyDir(String sourcePath, String destPath) throws IOException {
        //1. 建立与文件的联系
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        //如果源文件是一个文件夹
        if (sourceFile.isDirectory()) {
            destFile = new File(destFile, sourceFile.getName());
        }
        copyDirDetail(sourceFile, destFile);
    }

    private static void copyDirDetail(File sourceFile, File destFile) throws IOException {
        //2. 如果源文件是一个文件，则直接拷贝即可
        if (sourceFile.isFile()) {
            //拷贝文件
            CopyFileUtils.copyFile(sourceFile, destFile);
        } else if (sourceFile.isDirectory()) {
            //3. 如果源文件是一个文件夹，那么需要确保目标文件夹存在
            destFile.mkdirs();
            //4. 使用listFiles递归调用copyDirDetail拷贝文件夹以及子文件
            for (File subFile : sourceFile.listFiles()) {
                copyDirDetail(subFile, new File(destFile, subFile.getName()));
            }
        }
    }

}
