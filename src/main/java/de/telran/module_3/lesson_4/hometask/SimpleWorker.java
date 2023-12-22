package de.telran.module_3.lesson_4.hometask;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SimpleWorker {
    public static void main(String[] args) {
        BiConsumer<String, String> work = (n, j) ->standartWork(n, j);
        work.accept("Вася","убирать мусор");

        work = (n, j) -> System.out.println(n + " иди грузи " + j);
        work.accept("Вася","кирпичи");

        work = (n, j) -> System.out.println(n + " иди считай  " + j);
        work.accept("Вася","бутылки");
    }

    static void standartWork(String worker, String work) {
        System.out.println(worker + " выполняет работу "+work);
    }
}
