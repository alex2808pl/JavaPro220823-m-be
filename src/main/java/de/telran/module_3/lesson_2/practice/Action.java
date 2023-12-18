package de.telran.module_3.lesson_2.practice;

@FunctionalInterface
public interface Action {
    void action(int code, HttpCodes codes);
}
