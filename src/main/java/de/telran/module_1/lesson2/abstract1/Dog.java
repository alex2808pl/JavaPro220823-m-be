package de.telran.module_1.lesson2.abstract1;

public class Dog extends Animal {
    String name;

    @Override
    protected void voice() {
        System.out.println("Гав");
    }

    @Override
    protected void run() {
    }
}
