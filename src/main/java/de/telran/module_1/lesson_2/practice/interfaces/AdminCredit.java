package de.telran.module_1.lesson_2.practice.interfaces;

public interface AdminCredit extends Admin {
    void setCreditLimit(double sum);
    void setMaxWithdraw(double sum);
}
