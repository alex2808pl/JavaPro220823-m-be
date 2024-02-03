package de.telran.module_6.lesson_5.threadpools;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Building implements Runnable {
    private String city;
    private CountDownLatch latch;
    private String[] stages;
    private boolean printDateWithSeconds;

    public Building(CountDownLatch latch, String city, String[] stages, boolean printDateWithSeconds) {
        this.city = city;
        this.latch = latch;
        this.stages = stages;
        this.printDateWithSeconds = printDateWithSeconds;
    }

    @Override
    public void run() {
        for (int i = 0; i < stages.length; i++) {
            if (printDateWithSeconds)
                System.out.println(city + ": " + stages[i] + ", " + Thread.currentThread().getName() + " " + new Date());
            else
                System.out.println(city + ": " + stages[i] + ", " + Thread.currentThread().getName());
            latch.countDown();

            // можно показать без sleep, но лучше видно с этим параметром
            try {
                Thread.sleep((long)(Math.random()*1500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}