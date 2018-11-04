package com.wsh.io2;

import java.io.*;

/**
 * @Description: 字节处理流(增强功能, 提高性能, 处理流一定要在节点流之上)
 * @Author: weishihuai
 * @Date: 2018/11/1 20:56
 */
public class BufferInputStreamAndBufferOutStream {

    public static void main(String[] args) {
        //1.建立与源文件、目标文件的联系
        File sourceFile = new File("d:/aaa/a.txt");
        File destFile = new File("d:/aaa/aa.txt");

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            //在外层包裹一层处理流，加强功能
            inputStream = new BufferedInputStream(new FileInputStream(sourceFile));
            outputStream = new BufferedOutputStream(new FileOutputStream(destFile));
            //2. 定义缓冲字节数组以及实际接收长度len
            byte[] buffer = new byte[1024];
            int len = 0;
            //3. 循环读取文件中的内容
            while (-1 != (len = inputStream.read(buffer))) {
                //4.通过write将读取的内容写出到文件中
                outputStream.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭流
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
