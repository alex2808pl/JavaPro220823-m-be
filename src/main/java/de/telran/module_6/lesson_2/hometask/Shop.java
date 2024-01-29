package de.telran.module_6.lesson_2.hometask;

public class Shop {
    public static void main(String[] args) {

        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}

// Класс Магазин, хранящий произведенные товары
class Store{
    private int product=0;
    public synchronized void get() { // для покупателей
        while (product<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println(Thread.currentThread().getName()+" - Покупатель купил 1 товар");
        System.out.println(Thread.currentThread().getName()+" - Товаров на складе: " + product);
        notify();
    }

    public void getBlock() { // для покупателей

        synchronized (this) {
            while (product<1) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                }
            }
            product--;
            System.out.println(Thread.currentThread().getName()+" - Покупатель купил 1 товар");
            System.out.println(Thread.currentThread().getName()+" - Товаров на складе: " + product);
            notify();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void put() { //для поставщика
        while (product>=3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println(Thread.currentThread().getName()+" - Производитель добавил 1 товар");
        System.out.println(Thread.currentThread().getName()+" - Товаров на складе: " + product);
        notify();
    }

    public void putBlock() { //для поставщика

        synchronized(this) {
            while (product>=3) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                }
            }
            product++;
            notify();
        }
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);

    }
}
// класс Производитель
class Producer implements Runnable{

    Store store;
    Producer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
//            System.out.println(Thread.currentThread().getName()+" - Производитель добавил 1 товар");
            store.put();
//            store.putBlock();
        }
    }
}
// Класс Потребитель
class Consumer implements Runnable{

    Store store;
    Consumer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
//            System.out.println(Thread.currentThread().getName()+" - Покупатель купил 1 товар");
//            store.get();
            store.getBlock();
        }
    }
}