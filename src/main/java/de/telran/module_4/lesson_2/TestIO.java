package de.telran.module_4.lesson_2;

import java.io.*;

public class TestIO {
    public static void main(String[] args) throws IOException {
        File testFile = new File("testFileLastExample.txt");

        FileOutputStream stream = new FileOutputStream(testFile);
        stream.write("This is my first experience when I myself work with IO API. I can do everything!".getBytes());
        stream.close();

        boolean isExists = testFile.exists();
        System.out.println(isExists);

        testFile.delete();

        File parentDir = new File("testOne");
        removeDirAndSubDir(parentDir);
    }

    public static boolean removeDirAndSubDir(File dir) {
        // testOne
        //  - testTwo
        //    - testFour
        //  - TestThree


        File[] allContents = dir.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                removeDirAndSubDir(file);
            }
        }
        return dir.delete();

    }
}
