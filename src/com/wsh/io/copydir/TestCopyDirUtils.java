package com.wsh.io.copydir;

import java.io.IOException;

/**
 * @Description:
 * @Author: weishihuai
 * @Date: 2018/10/26 21:32
 */
public class TestCopyDirUtils {

    public static void main(String[] args) throws IOException {
        String sourcePath = "d:/aaa";
        String destPath = "d:/bbb";
        CopyDirUtils.copyDir(sourcePath, destPath);
    }

}
