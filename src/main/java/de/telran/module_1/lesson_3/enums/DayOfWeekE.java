package de.telran.module_1.lesson_3.enums;

import java.util.Arrays;
import java.util.List;

public enum DayOfWeekE {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    private String title;

    DayOfWeekE(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "DayOfWeekE{" +
                "title='" + title + '\'' +
                "} " + super.toString();
    }
}
