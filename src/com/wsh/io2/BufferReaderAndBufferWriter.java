package com.wsh.io2;

import java.io.*;

/**
 * @Description: 字符处理流(增强功能, 提高性能, 处理流一定要在节点流之上)
 * @Author: weishihuai
 * @Date: 2018/11/1 20:56
 */
public class BufferReaderAndBufferWriter {

    public static void main(String[] args) {
        //1. 建立与源文件、目标文件的联系
        File sourceFile = new File("d:/aaa/a.txt");
        File destFile = new File("d:/aaa/c.txt");

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            //2. 使用BufferedReader和BufferedWriter包裹FileReader和FileWriter
            //注意: 只能读取纯文本文件
            reader = new BufferedReader(new FileReader(sourceFile));
            writer = new BufferedWriter(new FileWriter(destFile));

            //3. 定义实际接收的字符串
            String str;

            //4. 使用reader.readLine()一行一行循环读取
            while (null != (str = reader.readLine())) {
                //5. 使用write()直接写出字符串到文件c.txt
                writer.write(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭流
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
