package de.telran.module_1.lesson_2.practice;

import de.telran.module_1.lesson_2.practice.entities.*;
import de.telran.module_1.lesson_2.practice.interfaces.Admin;
import de.telran.module_1.lesson_2.practice.interfaces.AdminDeposit;
import de.telran.module_1.lesson_2.practice.interfaces.Owner;
import de.telran.module_1.lesson_2.practice.interfaces.Сashier;

public class BankDemo {
    public static void main(String[] args) {
        DepositAccount depositAccount = new DepositAccount(1000, "Ivan", "1234567890123456");
        CreditAccount creditAccount = new CreditAccount("Ivan", "1234567890123456", 1000, 2000);
        CardAccount cardAccount = new CardAccount(1000, "Ivan", "1234567890123456");

        depositAccount.deposit(500);
        System.out.println(depositAccount.getBalance());

        creditAccount.withdraw(700);
        System.out.println(creditAccount.getBalance());

        cardAccount.withdraw(576.4);
        System.out.println(cardAccount.getBalance());

        Сashier cashier1 = new CreditAccount("Ivan", "1234567890123456", 1000, 2000);
        Сashier cashier = new DepositAccount(1000, "Ivan", "1234567890123456");
        Owner ivan = new DepositAccount(1000, "Ivan", "1234567890123456");
        ivan.deposit(300);
        System.out.println(ivan.getBalance());
        Admin mainAdmin = new DepositAccount(1000, "Ivan", "1234567890123456");
        mainAdmin.setStatus("closed");
        System.out.println(mainAdmin.getStatus());
        AdminDeposit adminDeposit = depositAccount;
        adminDeposit.setMaxDeposit(1200);
        System.out.println(depositAccount.getMaxDeposit());
    }
}
