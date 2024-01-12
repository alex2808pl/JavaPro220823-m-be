package de.telran.module_4.lesson_2;

import java.io.*;
import java.util.function.Function;

public class TestIO {
    public static void main(String[] args) throws IOException {

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

//    public static <U extends Double, T extends Number> U add(T arg1, T arg2) {
//        return Double.valueOf(arg1.doubleValue() + arg2.doubleValue());
//    }


}
