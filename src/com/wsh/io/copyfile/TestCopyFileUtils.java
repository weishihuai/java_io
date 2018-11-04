package com.wsh.io.copyfile;

import java.io.IOException;

/**
 * @Description:
 * @Author: weishihuai
 * @Date: 2018/10/26 21:32
 */
public class TestCopyFileUtils {

    public static void main(String[] args) {
        try {
            CopyFileUtils.copyFile("d:/aaa/a.txt", "d:/aaa/b.txt");
        } catch (IOException e) {
            System.out.println("文件拷贝失败！");
            e.printStackTrace();
        }
    }

}
