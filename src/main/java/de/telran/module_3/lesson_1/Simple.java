package de.telran.module_3.lesson_1;

import java.util.Arrays;

public class Simple {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 3, 5, 4, 6};
        int[] arr2 = {2, 1, 4, 3, 5, 6, 4};
        int[] arr3 = {2, 1, 4, 3, 5, 6, 4};

        System.out.println(Arrays.hashCode(arr1));
        System.out.println(Arrays.hashCode(arr2));
        System.out.println(Arrays.hashCode(arr3));
    }
}
