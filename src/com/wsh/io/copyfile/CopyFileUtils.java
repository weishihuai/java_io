package com.wsh.io.copyfile;

import java.io.*;

/**
 * @Description: 文件拷贝工具类
 * @Author: weishihuai
 * @Date: 2018/10/26 21:16
 */
public class CopyFileUtils {

    /**
     *
     * @param sourceFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File sourceFile, File destFile) throws IOException {
        //1. 源文件必须存在并且是文件
        if (!sourceFile.exists() || !sourceFile.isFile()) {
            System.out.println("源文件必须存在并且是文件");
            return;
        }

        if (destFile.isDirectory()) {
            return;
        }

        //2. 建立与文件的联系
        InputStream is = new FileInputStream(sourceFile);
        OutputStream os = new FileOutputStream(destFile);
        //实际接收长度
        int len = 0;
        //缓冲字节数组
        byte[] buffer = new byte[1024];
        //3. 循环读取文件
        while ((len = is.read(buffer)) != -1) {
            //4. 通过OutputStream写出到文件
            os.write(buffer, 0, len);
        }
        // 5. 关闭流
        os.flush();
        os.close();
        is.close();
    }

    public static void copyFile(String sourcePath, String destPath) throws IOException {
        //1. 源文件、目标文件建立联系
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        copyFile(sourceFile, destFile);
    }

}

