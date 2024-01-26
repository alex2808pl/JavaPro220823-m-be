package de.telran.module_6.lesson_2.hometask;

import java.util.ArrayList;

public class Bus {
    public static void main(String[] args) throws InterruptedException {
        JobQueue queue = new JobQueue();

        for (int i = 0; i < 10; i++) {
            Thread pas = new Thread(()->{
                    System.out.println(Thread.currentThread().getName()+"- передаю за проезд 3 евро");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
            });
            queue.put(pas);
        }

        //Водитель
        while (queue.jobs.size()>0) {
            queue.getJob().run();
        }
        System.out.println("Можно ехать!");

    }
}


class JobQueue
{
    ArrayList<Runnable> jobs = new ArrayList();

    public synchronized void put(Runnable job)
    {
        jobs.add(job);
        this.notifyAll();
    }

    public synchronized Runnable getJob() throws InterruptedException {
        while (jobs.size()==0)
            this.wait();

        return jobs.remove(0);
    }
}
