package com.mulanglin.file;

/**
 * @Author mulanglin
 * @Date 2020/9/30 9:27
 */

import java.io.File;

/**
 * 判断你D:\目录下（包括全部子目录）是否有后缀名为.jpg的文件
 */
public class JudgeJPGImpro {
    public static void main(String[] args) {
        File file = new File("D:\\");
        File[] files = file.listFiles();
        JudgeJPGImpro jj = new JudgeJPGImpro();
        jj.listJudegeJPG(files);
    }

    public void listJudegeJPG(File[] files) {
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isFile()) {
                if (f.getName().endsWith(".jpg")) {
                    System.out.println(f.getName());

                }
            }
            if (f.isDirectory()) {
                listJudegeJPG(f.listFiles());
            }
        }
    }
}
