package de.telran.module_4.lesson_2;

import java.util.Date;
import java.util.Scanner;

public class TestSystemIO {
    public static void main(String[] args) {
        System.out.println("Наша информация");
        System.out.print("Наша информация\n");
        System.out.print(" Наша\tинформация 2\n");
        String city = "Berlin";
        System.out.printf("Температура %s воздуха - %d", city, 25);

        //
        int x = 100;
        System.out.printf("Printing simple integer: x = %d\n", x);
        System.out.printf("Formatted with precision: PI = %.2f\n", Math.PI);

        float y = 3.14f;
        System.out.printf("Formatted to specific width: n = %.6f\n", y);

        y = 1234567.3f;
        System.out.printf("Formatted to right margin: n = %50.4f\n", y);

        //
        Date date = new Date();
        System.out.printf("%tT%n", date);

        // Символы H, M, S отвечают за часы, минуты и секунды
        System.out.printf("hours %tH: minutes %tM: seconds %tS%n", date, date, date);

        System.out.printf("%1$tA, %1$tB %1$tY %n", date);

        // --- System.in
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(n+k);

        // --- System.err
        System.err.println("Наша ошибка");
        System.err.printf("Ошибка номер - %d", 25);
    }
}
