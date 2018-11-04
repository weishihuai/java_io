package com.wsh.io5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Description: 打印流
 * @Author: weishihuai
 * @Date: 2018/11/3 21:14
 */
public class PrintStreamDemo {

    public static void main(String[] args) {
        try {
            PrintStream ps = new PrintStream(new FileOutputStream(new File("d:/aaa/ps.txt")));
            ps.println("hello printstream");
            ps.close();

            //三个常量
//            System.out;
//            System.in;
//            System.err;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
