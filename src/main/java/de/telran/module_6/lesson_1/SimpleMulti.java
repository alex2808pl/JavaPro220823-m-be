package de.telran.module_6.lesson_1;

public class SimpleMulti {
    public static void main(String[] args) {
        Thread tr1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Поток 1 -> "+ i);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        MyThread tr2 = new MyThread(tr1);

        MyThreadRun tr3 = new MyThreadRun(3, "Runnable");

        Runnable run1 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable lambda поток -> "+ i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        tr1.start();
        tr2.start();
        //tr3.run(); // не рекомендуется
        Thread tr4 = new Thread(tr3);
        tr4.start(); //рекомендованный подход при работе с Runnable

        new Thread(run1).start(); // еще один вариант запуска с Runnable



        for (int i = 0; i < 10; i++) {
            System.out.println("Главный поток -> "+ i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            tr1.join();
            tr2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Программа завершилась");

    }
}

class MyThread extends Thread {
    Thread trIn;
    public MyThread(Thread trIn) {
        this.trIn = trIn;
    }
    public MyThread() {
    }
    @Override
    public void run() {
        try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Поток 2 -> " + i);
                     Thread.sleep(800);
                }
            trIn.join();
            System.out.println("Поток 2 -> Завершен");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}

class MyThreadRun implements Runnable {
    private int numThread;
    private String name;

    public MyThreadRun(int numThread, String name) {
        this.numThread = numThread;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Поток " +name+ " "+ numThread+" -> " + i);
                Thread.sleep(800);
            }
            System.out.println("Поток " +name+ " "+ numThread+" -> Завершен");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

