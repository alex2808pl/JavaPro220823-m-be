package de.telran.module_5.lesson_3;

import java.util.Date;
import java.util.Locale;

public class SimpleDate {
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println("Текущая дата = " + date1);

        Date date2 = new Date(525346746557L);
        System.out.println("Наша дата = " + date2);

//        Date date3 = new Date(124, 1, 19);
//        System.out.println("Текущая дата = "+date3);

        boolean fl = date1.after(date2); // date1 после date2
        System.out.println(fl);

        fl = date1.before(date2); // date1 перед date2
        System.out.println(fl);

        date2.setTime(date1.getTime());

        int compare = date1.compareTo(date2);
        System.out.println(compare);

        System.out.println("Время в милисекундах = "+date1.getTime());

        System.out.println();

        Locale locale = new Locale("uk"); //украинская локализация
        Locale.setDefault(locale);
        Date now = new Date();
        String date = String.format(locale, "%tc\n", now) + // длинная строка
                String.format(locale, "%tD\n", now) + //(MM/DD/YY)
                String.format(locale, "%tF\n", now) + //(YYYY-MM-DD)
                String.format(locale, "%tr\n", now) + //Full 12-hour time
                String.format(locale, "%tz\n", now) + //Time zone GMT offset
                String.format(locale, "%tZ\n", now);//Localized time zone abbreviation

        System.out.println(date);

    }
}
