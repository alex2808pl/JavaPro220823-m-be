package de.telran.module_6.lesson_1;

public class SimpleCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        MyThread1 tr1 = new MyThread1(counter, 1);
        MyThread1 tr2 = new MyThread1(counter, 2);
        MyThread1 tr3 = new MyThread1(counter, 3);
        tr1.start();
        tr2.start();
        tr3.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Главный поток  -> " + i);
            counter.addCounter(10);
        }

        tr1.join();
        tr2.join();
        tr3.join();
        System.out.println("Counter = "+counter.getCounter());

    }
}


class Counter {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public synchronized void addCounter(int counter) {
        //this.counter += counter;
            System.out.println("Counter = "+this.counter);
            int temp = getCounter();
            setCounter(temp + 10);
    }

    public  void subCounter(int counter) {
        System.out.println("Counter = "+this.counter);
        synchronized (this) {
            int temp = getCounter();
            setCounter(temp - 10);
        }
    }
}

class MyThread1 extends Thread {
    private Counter counter;
    private int numThread;

    public MyThread1(Counter counter, int numThread) {
        this.counter = counter;
        this.numThread = numThread;
    }

    public MyThread1() {
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Поток "+numThread+" -> " + i);
//                int temp = counter.getCounter();
//                Thread.sleep(1);
//                counter.setCounter(temp+10);
                  counter.subCounter(10);
                  Thread.sleep(10);

            }
            System.out.println("Поток "+numThread+" -> Завершен");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

