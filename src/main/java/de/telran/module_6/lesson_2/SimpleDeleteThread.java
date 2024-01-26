package de.telran.module_6.lesson_2;

public class SimpleDeleteThread {
    public static void main(String[] args) throws InterruptedException {

        // 1й вариант потока
        Thread thread1 = new Thread(()-> {
            int j;
            try {
                for (j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + "- обрабатывает шаг -> " + j);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                 System.out.println("Произошло исключение InterruptedException -> "+Thread.currentThread().getName());
                 j = 10;
            }
            System.out.println("Поток прекращает работу!");
        });

        // 2й вариант потока
        Thread thread2 = new Thread(()-> {
            boolean isInterrupted = false;
            int j=0;
            try {
                while (!isInterrupted && j<10) {
                    System.out.println(Thread.currentThread().getName() + "- обрабатывает шаг -> " + j);
                    Thread.sleep(1000);
                    j++;
                }
            } catch (InterruptedException e) {
                System.out.println("Произошло исключение InterruptedException -> "+Thread.currentThread().getName());
                isInterrupted = true;
            }
            System.out.println("Поток прекращает работу!");
        });
        thread1.start();
        thread2.start();

        Thread.sleep(3000);
        //thread.stop(); //нельзя использовать
        thread1.interrupt();

        Thread.sleep(4000);
        thread2.interrupt();

        System.out.println("Конец программы! ");

    }
}
