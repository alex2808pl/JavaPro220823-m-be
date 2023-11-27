package de.telran.module_2.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleCloneArrays {
    public static void main(String[] args) {
        int[] arInt = {1,2,6,3,8,5,4,7};
        System.out.println(Arrays.toString(arInt));

        int[] arInt1 = arInt.clone();
        System.out.println(Arrays.toString(arInt1));

        System.out.println(arInt == arInt1);


        // 2-мерный массив
        int[][] arInt2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};//new int[3][3];
        System.out.println(Arrays.deepToString(arInt2));

        int[][] arInt2clone = arInt2.clone();
        System.out.println(Arrays.deepToString(arInt2clone));

        System.out.println(arInt2 == arInt2clone);
        System.out.println(arInt2.equals(arInt2clone));
        System.out.println(Arrays.deepEquals(arInt2, arInt2clone));

        for (int i=0; i < arInt2.length; i++) {
            int [] arr = arInt2[i];
            int [] arrClone = arInt2clone[i];
            System.out.println(arr == arrClone);
        }

        // бинарный поиск
        int indBinary = binarySearch(arInt, 0, arInt.length-1, 2);
        System.out.println("2 индекс -> "+indBinary);

        indBinary = Arrays.binarySearch(arInt, 2);
        System.out.println("2 индекс -> "+indBinary);

        //сортировки
        Arrays.sort(arInt);
        System.out.println(Arrays.toString(arInt));
        System.out.println(Arrays.toString(arInt1));
//        Collections.sort();
    }

    public static int binarySearch(int[] arr, int leftIdx, int rightIdx, int element) {
        if (rightIdx >= leftIdx) {

            int mid = leftIdx + (rightIdx - leftIdx) / 2;

            if (arr[mid] == element) {
                return mid;
            }

            if (arr[mid] > element)
                return binarySearch(arr, leftIdx, mid - 1, element);

            return binarySearch(arr, mid + 1, rightIdx, element);
        }

        return -1;
    }

}
