package com.wsh.io2;

import java.io.*;

/**
 * @Description: 转换流(字节流 转换为 字符流)
 * @Author: weishihuai
 * @Date: 2018/11/1 21:22
 * <p>
 * 转换流： 主要用于解决乱码问题(保证源文件的编码集已知)
 */
public class InputStreamReaderAndOutputStreamWriter {

    public static void main(String[] args) throws IOException {
        //1. 指定解码字符集
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:/aaa/c.txt")), "utf-8"));
        //2. 定义实际接收字符串
        String string;
        //3. 一行一行读取纯文本文件内容
        while (null != (string = reader.readLine())) {
            System.out.println(string);
        }
    }

}
