package de.telran.module_5.lesson_3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.Callable;

public class SimpleCalendar {
    public static void main(String[] args) {
        Calendar calendar1 = new GregorianCalendar();
        System.out.println(calendar1);
        Calendar calendar2 = Calendar.getInstance();
        System.out.println(calendar2);

        Calendar calendar3 = new GregorianCalendar(2022, Calendar.JULY, 25);
        System.out.println(calendar3.get(Calendar.MONTH));
        calendar3.set(Calendar.HOUR, 11);
        calendar3.set(Calendar.MINUTE, 50);
        System.out.println(calendar3.get(Calendar.HOUR));

        calendar3.add(Calendar.MONTH, 2);
        System.out.println(calendar3.get(Calendar.MONTH));

        calendar3.add(Calendar.MONTH, -4);
        System.out.println(calendar3.get(Calendar.MONTH));

        // форматирование строки при выводе даты
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss.SSS");
        String dateStr = simpleDateFormat.format(new Date());
        System.out.println(dateStr);

        //Использовать Calendar
        simpleDateFormat = new SimpleDateFormat("dd MMMyyyy");
        dateStr = simpleDateFormat.format(calendar1.getTime());
        System.out.println(dateStr);

        Locale locale = new Locale("ru");
        simpleDateFormat = new SimpleDateFormat("dd-MMM-yy, d, D, K:m", locale);
        dateStr = simpleDateFormat.format(calendar1.getTime());
        System.out.println(dateStr);






    }
}
