package de.telran.module_2.lesson_3.practice;

public class LiveAnimals {
    public static void main(String[] args) {
        long start = 10_000_000;
        int days = 10 * 365;
        for (int i = 1; i <= days; i++) {
            start = start - 8 + 14;
            if(i % 365 == 0)
                    System.out.println("Сейчас живет в Лимпопо - "+start);
        }
    }
}
