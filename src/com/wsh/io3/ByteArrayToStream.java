package com.wsh.io3;

import java.io.*;

/**
 * @Description: 字节数组流与文件流对接
 * @Author: weishihuai
 * @Date: 2018/11/2 20:57
 */
public class ByteArrayToStream {

    public static void main(String[] args) {
        byte[] bytes = getBytesFromFile("d:aaa/a.txt");
        System.out.println(new String(bytes));
        toFileFromByteArray(bytes, "d:/aaa/t.txt");
    }

    /**
     * 从文件中读取到字节数组流中(文件输入流读取文件/字节数组输出流将文件写出到字节数组)
     *
     * @param sourcePath 源文件路径
     * @return
     */
    public static byte[] getBytesFromFile(String sourcePath) {
        File sourceFile = new File(sourcePath);
        byte[] dest;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            is = new BufferedInputStream(new FileInputStream(sourceFile));
            bos = new ByteArrayOutputStream();

            int len = 0;
            byte[] buffer = new byte[1024];
            while (-1 != (len = is.read(buffer))) {
                bos.write(buffer, 0, buffer.length);
            }
            bos.flush();
            dest = bos.toByteArray();
            return dest;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 字节数组输出到文件(字节数组输入流将字节数组读取出来/文件输出流将字节数组写出到文件保存)
     *
     * @param bytes 字节数组
     */
    public static void toFileFromByteArray(byte[] bytes, String destPath) {
        OutputStream os = null;
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        int len = 0;
        byte[] buffer = new byte[1024];
        try {
            os = new FileOutputStream(new File(destPath));
            while (-1 != (len = bis.read(buffer))) {
                os.write(buffer, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
