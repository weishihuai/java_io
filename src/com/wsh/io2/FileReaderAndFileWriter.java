package com.wsh.io2;

import java.io.*;

/**
 * @Description: 纯文本读取
 * @Author: weishihuai
 * @Date: 2018/11/1 20:40
 */
public class FileReaderAndFileWriter {

    public static void main(String[] args) {
        //先写内容到文件
        writeFile();
        //再读取出来
        readFile();
    }

    /**
     * 把内容输出到文件
     */
    public static void writeFile() {
        //1. 需要写出的目标文件路径
        File file = new File("d:/aaa/b.txt");
        Writer writer = null;

        try {
            //2. 建立与目标文件的联系
            writer = new FileWriter(file);
            //3. 使用write()直接写出字符串(只能写出纯文本内容)
            writer.write("hello world!!!!!!!!!");
            //4. 刷新流
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭流
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 读取文件中的内容
     */
    public static void readFile() {
        //1. 定义源文件路径
        File file = new File("d:/aaa/b.txt");
        Reader reader = null;

        try {
            //2. 建立与源文件的联系
            reader = new FileReader(file);
            //3. 字符缓存数组
            char[] buffer = new char[1024];
            //4. 定义实际接收长度
            int len = 0;
            //5. 循环读取文件内容
            while (-1 != (len = reader.read(buffer))) {
                System.out.println(new String(buffer));
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
            System.out.println("源文件读取失败");
        } finally {
            //6. 关闭流
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭流失败");
                }
            }
        }
    }

}
