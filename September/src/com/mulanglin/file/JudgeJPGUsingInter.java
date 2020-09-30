package com.mulanglin.file;

import java.io.File;
import java.io.FileFilter;

/**
 * @Author mulanglin
 * @Date 2020/9/30 9:13
 */
public class JudgeJPGUsingInter {
    public static void main(String[] args) {
        File file = new File("D:\\");
        JpgFileFilter fileFilter = new JpgFileFilter();
        File[] fileArr = file.listFiles(fileFilter);
        for (File f : fileArr) {
            System.out.println(f.getName());
        }
    }
}

class JpgFileFilter implements FileFilter{

    @Override
    public boolean accept(File pathname) {
        if(pathname.isFile()&&pathname.getName().endsWith(".jpg")){
            return true;
        }
        return false;
    }
}