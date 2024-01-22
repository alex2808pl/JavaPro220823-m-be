package de.telran.module_5.lesson_4;

public class Calc {
    public int add(int a, int b) {
        return a+b;
    }

    public int sub(int a, int b) {
        return a-b;
    }

    public int mul (int a, int b) {
        return a*b;
    }

    public int div(int a, int b) throws InterruptedException {
        Thread.sleep(1000); // специально для теста timeout
        if(b==0)
            throw new IllegalArgumentException("Второй параметр не должен быть 0");
        return a/b;
    }

}
