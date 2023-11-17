package de.telran.module_1.lesson_2.practice.interfaces;

public interface Admin {
    void setStatus(String newStatus);
    String getStatus();
}


//    Администратор может сменить статус счета,  Установить макс.сумма пополнения, Установить кредитный лимит,
//    Установить макс.сумма снятия, Установить размер овердрафта