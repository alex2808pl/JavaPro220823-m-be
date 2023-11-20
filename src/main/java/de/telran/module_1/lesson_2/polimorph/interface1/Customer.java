package de.telran.module_1.lesson_2.polimorph.interface1;

public interface Customer {
    void orderPizza();
    default void eatPizza() {
        System.out.println("По умолчанию кушаем ртом");
    };
}

