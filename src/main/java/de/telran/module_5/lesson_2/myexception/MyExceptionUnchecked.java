package de.telran.module_5.lesson_2.myexception;

public class MyExceptionUnchecked extends RuntimeException{
    private int number;

    public MyExceptionUnchecked() {
    }

    public MyExceptionUnchecked(String message, int number) {
        super(message + "число = "+number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void print() {
        System.out.println("Я сработал! "+this.getClass().getName());
    }
}
