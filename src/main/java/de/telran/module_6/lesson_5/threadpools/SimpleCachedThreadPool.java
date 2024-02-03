package de.telran.module_6.lesson_5.threadpools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleCachedThreadPool {
    public static void main(String[] args) {

        String[] stages = new String[]{
                "1.Проектная деятельность",
                "2.Старт строительных работ",
                "3.Финиш строительных работ",
                "4.Отделочные работы"
        };

        CountDownLatch cd1 = new CountDownLatch(stages.length);
        CountDownLatch cd2 = new CountDownLatch(stages.length);
        CountDownLatch cd3 = new CountDownLatch(stages.length);
        CountDownLatch cd4 = new CountDownLatch(stages.length);

        ExecutorService es = Executors.newCachedThreadPool();

        System.out.println("Запуск потоков");

        es.execute(new Building(cd1, "Dusseldorf", stages, false));
        es.execute(new Building(cd2, "Cologne", stages, false));
        es.execute(new Building(cd3, "Dortmund", stages, false));
        es.execute(new Building(cd4, "Essen", stages, false));

        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        es.shutdown();
        System.out.println("Завершение потоков");

    }
}
