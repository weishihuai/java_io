package com.wsh.serialize;

import java.io.*;
import java.util.UUID;

/**
 * @Description: 序列化与反序列化
 * @Author: weishihuai
 * @Date: 2018/11/4 19:45
 * 说明:
 * 序列化: 输出流 ObjectOutputStream
 * 反序列化: 输入流 ObjectInputStream
 * <p>
 * 1. 先序列化再反序列化
 * 2. 不是所有的对象都可以序列化与反序列化
 * 3. 不是所有的属性都需要序列化,不需要序列化的属性使用transient关键字修饰
 */
public class SerializableDemo {

    public static void main(String[] args) {
        //将对象序列化到d:/aaa/member.txt中
//        writeObjectToBinary("d:/aaa/member.txt");
        //将d:/aaa/member.txt中的二进制文件还原为实体对象
        Member member = readObjectFromBinary("d:/aaa/member.txt");
        System.out.println(member);
    }

    /**
     * 序列化操作
     *
     * @param destPath 序列化后存放二进制文件的目标路径
     */
    public static void writeObjectToBinary(String destPath) {
        //1. 创建需要序列化的对象
        Member member = new Member(UUID.randomUUID().toString(), "zhangsan", 60.5D);
        ObjectOutputStream oos = null;
        try {
            //2. 建立与输出文件的路径的联系
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(destPath))));
            //3. 使用ObjectOutPutStream的writeObject()方法将对象序列化到文件
            oos.writeObject(member);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 反序列化操作
     *
     * @param sourcePath 反序列化时二进制文件的源路径
     * @return 反序列化后的对象
     */
    public static Member readObjectFromBinary(String sourcePath) {
        //1. 建立与源二进制文件的联系
        File file = new File(sourcePath);
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            // 2. 使用ObjectInputStream的readObject()方法将二进制文件还原为实体对象
            Object object = ois.readObject();
            // 3. 判断是否为Member类型
            if (object instanceof Member) {
                return (Member) object;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
