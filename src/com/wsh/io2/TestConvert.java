package com.wsh.io2;

import java.io.UnsupportedEncodingException;

/**
 * @Description: 编码与解码
 * @Author: weishihuai
 * @Date: 2018/11/1 21:15
 * <p>
 * 1.编码解码字符集不一致
 * 2.字节数不够,长度丢失
 */
public class TestConvert {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //解码  utf-8
        String string = "中国";
        //编码
        byte[] bytes = string.getBytes();

        //中国
        System.out.println(new String(bytes));

        //设定编码字符集为gbk
        bytes = string.getBytes("gbk");

        // �й�  乱码(编码与解码集不一致)
        System.out.println(new String(bytes));

    }

}
