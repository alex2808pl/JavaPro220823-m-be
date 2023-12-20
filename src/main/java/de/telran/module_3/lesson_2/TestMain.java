package de.telran.module_3.lesson_2;

import java.util.Arrays;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
        System.out.println(even);
        even = number.stream().filter(x -> x % 2 == 0).reduce((ans, i) -> (ans + i)).stream().mapToInt(Integer::intValue).sum();
        System.out.println(even);
        System.out.println(number.stream().filter(x -> x % 2 == 0).reduce((ans, i) -> (ans + i)).get());
    }
}
