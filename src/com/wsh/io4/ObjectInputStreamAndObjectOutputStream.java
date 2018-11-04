package com.wsh.io4;

import java.io.*;
import java.util.UUID;

/**
 * @Description: 序列化与反序列化
 * @Author: weishihuai
 * @Date: 2018/11/3 14:13
 * <p>
 * 说明:
 * 序列化: 输出流  ObjectOutputStream
 * 反序列化: 输入流 ObjectInputStream
 * 1. 先序列化再反序列化
 * 2. 实现Serializable接口的类才能实现序列化
 * 3. 不是所有的属性都需要序列化,不需要序列化的属性使用transient关键字修饰
 */
public class ObjectInputStreamAndObjectOutputStream {

    public static void main(String[] args) {
        Person person = new Person(UUID.randomUUID().toString(), "zhangsan", 180.1D);
        //序列化
//        writeObject(person, "d:/aaa/person.txt");

        //反序列化
       Person per =  readObject("d:/aaa/person.txt");
       System.out.println(per);
    }

    public static void writeObject(Person person, String destPath) {
        File destFile = new File(destPath);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(destFile)));
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Person readObject(String sourcePath) {
        File file = new File(sourcePath);
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            Object object = ois.readObject();
            if (object instanceof Person) {
                return (Person) object;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
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
