package de.telran.module_5.lesson_4;

public class SimpleCalc {
    public static void main(String[] args) throws InterruptedException {
        Calc calc = new Calc();
        System.out.println(calc.add(5,12));

        System.out.println(calc.div(5,2));
    }
}
