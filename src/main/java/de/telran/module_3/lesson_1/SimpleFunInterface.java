package de.telran.module_3.lesson_1;

@FunctionalInterface
public interface SimpleFunInterface{
    void doWork(int inParam);

//    void doWork();

    default void beep() {
        System.out.println("default SimpleFunInterface:beep");
    };
    static void other() {
        System.out.println("dSimpleFunInterface:other");
    };
}
