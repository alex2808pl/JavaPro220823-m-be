package de.telran.module_1.lesson_2.abstract1;

public abstract class Animal {
    protected String type;
    protected abstract void voice();
    protected abstract void run();
    final protected void rest() {
        System.out.println("Они спят");
    }
}
