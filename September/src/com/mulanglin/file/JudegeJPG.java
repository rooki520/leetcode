package com.mulanglin.file;

/**
 * @Author mulanglin
 * @Date 2020/9/30 9:07
 */

import java.io.File;

/**
 * 判断D:\根目录下是否有后缀名为.jpg的文件，如果有则输出该文件名称
 */
public class JudegeJPG {
    public static void main(String[] args) {
        //通过File类的构造方法生成D：\目录的File对象
        File file = new File("D:\\");
        //获取该目录下的所有文件或所有文件夹的对象
        File[] files = file.listFiles();

        //遍历files数组，得到每一个File对象
        for(File f:files){
            //判断是否为文件
            if(f.isFile()){
                //判断是否以.jpg结尾
                if(f.getName().endsWith(".jpg")){
                    System.out.println(f.getName());
                }
            }
        }

    }
}
