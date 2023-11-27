package de.telran.module_2.lesson_1;

import java.util.Arrays;

public class SimpleArrays {
    public static void main(String[] args) {
        int[] arInt = {1,2,6,3,8,5,4,7};
        System.out.println(arInt[5]);
        System.out.println(Arrays.toString(arInt));
//        for (int el : arInt) {
//            el++;
//        }
        for (int i=0; i<arInt.length; i++) {
            arInt[i]++;
        }
        System.out.println(Arrays.toString(arInt));

        // 2-мерный массив
        int[][] arInt2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};//new int[3][3];
        System.out.println(arInt2[1][2]);
        System.out.println(Arrays.toString(arInt2));

        for (int[] el : arInt2) {
            System.out.println(Arrays.toString(el));
        }

        for (int i=0; i < arInt2.length; i++) {
            int [] arr = arInt2[i];
            for (int j=0; j<arr.length; j++) {
                arr[j]++;
            }
         }
        System.out.println(Arrays.deepToString(arInt2));

        // 3 мерный массив

        int[][][] arInt3 = {{{1,2,3},{5,6,7}},
                          {{9,10,11},{5,7,4}},
                          {{11,12,13},{15,16,17}}};//new int[3][3][3];

        System.out.println(Arrays.deepToString(arInt3));

        for (int i=0; i < arInt3.length; i++) {
            int[][] arr2 = arInt3[i];
            for (int j=0; j<arr2.length; j++) {
                int [] arr = arr2[j];
                for (int z=0; z<arr.length; z++) {
                    arr[z]++;
                }
            }
        }
        System.out.println(Arrays.deepToString(arInt3));

        // другая можел доступа через индексы
        for (int i=0; i < arInt3.length; i++) {
            for (int j=0; j<arInt3[i].length; j++) {
                for (int z=0; z<arInt3[i][j].length; z++) {
                    arInt3[i][j][z]++;
                }
            }
        }
        System.out.println(Arrays.deepToString(arInt3));

        // третья модель доступа через индексы в конце
        for (int[][] arr2 : arInt3) {
            for (int[] arr : arr2) {
                for (int k = 0; k < arr.length; k++) {
                    arr[k]++;
                }
            }
        }
        System.out.println(Arrays.deepToString(arInt3));

        int[][] arInt2_ = {{1,2,3,4},{5,6,7,8,15},{9,10,11,12}};//new int[3][3];
        System.out.println(Arrays.deepToString(arInt2_));
    }
}
