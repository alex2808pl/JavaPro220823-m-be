package de.telran.module_1.lesson_2.practice.entities;

import de.telran.module_1.lesson_2.practice.interfaces.Owner;
import de.telran.module_1.lesson_2.practice.interfaces.Сashier;

public abstract class Account implements Сashier, Owner {
    protected String accountNumber;
    protected double balance;
    protected String status;
    protected String openDate;
    protected String closeDate;

    public double getBalance() {
        return balance;
    }

    public void setStatus(String status) {
        if (status.equals("opened") || status.equals("closed") || status.equals("frozen")){
            this.status = status;
        } else {
            System.out.println("Incorrect status, try again.");
        }
    }

    public void closeAccount(String closeDate) {
        if (balance == 0) {
            this.status = "closed";
            this.closeDate = closeDate;
            System.out.println("Your account is closed");
        } else {
            System.out.println("You can't close your account");
        }
    }
}
