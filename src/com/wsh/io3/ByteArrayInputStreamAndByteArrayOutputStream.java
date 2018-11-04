package com.wsh.io3;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Description: 字节数组流 字节流
 * @Author: weishihuai
 * @Date: 2018/11/2 20:43
 */
public class ByteArrayInputStreamAndByteArrayOutputStream {

    public static void read(byte[] bytes) {
        ByteArrayInputStream bis = null;
        //1. 实际接收长度
        int len = 0;
        //字节数组
        byte[] bytes1 = new byte[1024];
        try {
            //2. 创建字节数组输入流
            bis = new ByteArrayInputStream(bytes);
            //3. 循环将文件中的字节数组读取出来
            while (-1 != (len = bis.read(bytes1))) {
                System.out.println(new String(bytes1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] write() {
        //字节数组
        byte[] dest;
        String string = "字节数组流 字节流 节点流";
        //需要写入文件的字节数组
        byte[] bytes = string.getBytes();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //使用write将字节数组写入到文件中
        bos.write(bytes, 0, bytes.length);
        //使用toByteArray()将输出流转化为字节数组
        dest = bos.toByteArray();
        return dest;
    }

    public static void main(String[] args) {
//        read();
        read(write());
    }

}
