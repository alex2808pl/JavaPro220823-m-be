package de.telran.module_6.lesson_2;

import java.util.ArrayList;
import java.util.List;

public class SimpleDaemon {
    public static void main(String[] args) throws InterruptedException{
        List<Thread> ths = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 10; j++) {
                     System.out.println(Thread.currentThread().getName()+"- обрабатывает шаг -> "+j);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.setDaemon(true); // демон
            ths.add(thread);
            thread.start();
        }

//        for (Thread th : ths) {
//            th.join();
//         }

        Thread.sleep(500);
        System.out.println("Конец программы!");
    }
}

