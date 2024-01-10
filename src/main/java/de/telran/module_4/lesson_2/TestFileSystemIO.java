package de.telran.module_4.lesson_2;

import java.io.File;
import java.io.IOException;

public class TestFileSystemIO {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        boolean wasCreatedFile = file.createNewFile();
        System.out.println("created file " + wasCreatedFile);
        boolean isExists = file.exists();
        System.out.println("file exists " + isExists);
        long length = file.length();
        System.out.println("size file " +length);
//        boolean success = file.delete();
//        System.out.println(success);

        File dir = new File("newdir");
        boolean wasCreated = dir.mkdir(); //создание папки
        System.out.println("created dir " + wasCreated);
        boolean success = dir.delete();
        System.out.println(success);

        success = deleteDir(dir);
        System.out.println(success);
    }

    public static boolean deleteDir(File dir){
        File[] files = dir.listFiles();
        if(files != null){
            for(File file : files){
                if(file.isDirectory()){
                    deleteDir(file);
                } else {
                    file.delete();
                }
            }
        }
        return dir.delete();
    }
}
