package de.telran.module_5.lesson_2.myexception;

import java.util.Scanner;

public class SimpleUserException {
    public static void main(String[] args) throws MyExceptionChecked {

        int valInt = 0;
        try {
            valInt =  inputData();
        } catch (MyExceptionUnchecked ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
            ex.print();
        } catch (Exception ex) {  // для обработки всех логических ошибок, чтобы мы не упали
            System.out.println(ex.getMessage());
        }

        System.out.println("Результат = " + 25.0 / valInt);

        System.out.println("Конец программы");
    }

    public static int inputData() throws MyExceptionChecked {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int valInt = scanner.nextInt();

        if(valInt<0)
            throw new MyExceptionChecked();

        if(valInt==0)
            throw new MyExceptionUnchecked("Наш текст исключения ", valInt);

        return valInt;
    }
}
