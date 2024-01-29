package de.telran.module_6.lesson3.atomic;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleBank {
    volatile int accountVol;
    public static void main(String[] args) {
//        Account account = new Account();
//        new Husband(account).start();
//        new Wife(account).start();

        AtomicInteger accountAtom = new AtomicInteger(0);
        new Husband(accountAtom).start();
        new Wife(accountAtom).start();




    }

}

class Account {
    private double sumAccount;

    public double getSumAccount() {
        return sumAccount;
    }

    public void setSumAccount(double sumAccount) {
        this.sumAccount = sumAccount;
    }

    public synchronized double getSumAccountAndAdd(double addSum) {
           double currentSum = sumAccount;
           sumAccount = currentSum + 100;
//           sumAccount+=addSum;
           return sumAccount;
    }

    @SneakyThrows
    public synchronized double getSumAccountAndSub(double addSum) {
        double currentSum = sumAccount;
        Thread.sleep(100);
        sumAccount = currentSum - 100;
//        sumAccount-=addSum;
        return sumAccount;
    }
}

class Husband extends Thread {
    Account account;
    AtomicInteger accountAtom;

    public Husband(AtomicInteger accountAtom) {
        this.accountAtom = accountAtom;
    }

    public Husband(Account account) {
        this.account = account;
    }
    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
////            double currentSum = account.getSumAccount();
//            System.out.println(Thread.currentThread().getName() + " остаток на счету = "+account.getSumAccount());
////            account.setSumAccount(currentSum + 100);
//            account.getSumAccountAndAdd(100);
//            System.out.println(Thread.currentThread().getName() + " остаток на счету = "+account.getSumAccount());

            accountAtom.addAndGet(100);
            System.out.println(Thread.currentThread().getName() + " остаток на счету = "+accountAtom.get());

//            sleep(50);
        }
    }
}

class Wife extends Thread {
    Account account;
    AtomicInteger accountAtom;


    public Wife(Account account) {
        this.account = account;
    }

    public Wife(AtomicInteger accountAtom) {
        this.accountAtom = accountAtom;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
////            double currentSum = account.getSumAccount();
//            System.out.println(Thread.currentThread().getName() + " остаток на счету = "+account.getSumAccount());
////            account.setSumAccount(currentSum - 100);
//            account.getSumAccountAndSub(100);
//            System.out.println(Thread.currentThread().getName() + " остаток на счету = "+account.getSumAccount());

            accountAtom.addAndGet(-100);
            System.out.println(Thread.currentThread().getName() + " остаток на счету = "+accountAtom.get());

            sleep(100);
        }
    }
}


