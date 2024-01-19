package de.telran.module_5.lesson_3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class SimpleLocalDate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int year = date.getYear();

        int month = date.getMonthValue(); //1...12
        System.out.println(month);
        Month monthEnum = date.getMonth();
        System.out.println(monthEnum);

        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(date);
        System.out.println(dayOfWeek);
        System.out.printf("%d.%d.%d \n", dayOfMonth, month, year);


        LocalDate date1 = LocalDate.of(1996, 1, 1);
        System.out.println(date1);

        date1 = date1.plusYears(4);
        date1 = date1.plusMonths(3);
        date1 = date1.plusDays(14);
        System.out.println(date1);

        date1 = date1.minusMonths(10);
        date1 = date1.minusDays(3);
        System.out.println(date1);

        System.out.println(date.isAfter(date1));
        System.out.println(date.isBefore(date1));


    }
}
