package de.telran.module_5.lesson_2;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleException {

    public static void main(String[] args)  {
        try {
            System.out.println("Ввели число = " + inputIntRecursive());
        } catch (RuntimeException e) {
            Throwable cause = e.getCause();
            if(cause instanceof IOException) {
                System.out.println(e.getCause().getMessage());
            }
        }
        System.out.println("Конец программы");
    }

    public static int inputInt() {
        int inInt = 0;
        boolean isInput = false;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите число: ");
                inInt = scanner.nextInt();
                isInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Введите корректные данные");
                isInput = true;
            }
        } while (isInput);
        return inInt;
    }

    public static int inputIntRecursive()  {
        runCheckedException();
        int inInt = 0;
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите число: ");
                inInt = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Введите корректные данные");
                inInt = inputIntRecursive();
            }
        return inInt;
    }

    public static void runCheckedException()  {
        // check Exception.
        File testFile = new File("testFile.txt");
        try {
            testFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
