package de.telran.module_1.lesson2.abstract1;

public abstract class Animal {
    protected String type;
    protected abstract void voice();
    protected abstract void run();
    protected void rest() {
        System.out.println("Они спят");
    }
}
