package de.telran.module_4.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMethodGeneric {
    public static void main(String[] args) {
        List list = Arrays.asList("Автор", "Книга");
        for (Object el : list) {
            // из Оbject в String
            String data = Utils.getValue(el);
            System.out.println(data);
            System.out.println((String)Utils.getValue(el));
            // на этапе компиляции T заменяется на String
            System.out.println(Utils.<String>getValue(el));

            System.out.println(Utils.getValue(el,String.class));

            // всегда ставьте знаки <> справа
            List<String> listStr = Arrays.asList("Автор", "Книга");
            List<Integer> listInt = new ArrayList(listStr); //new ArrayList<>(listStr);
            Integer i = listInt.get(0);
            System.out.println(i);

        }
    }
}

class Utils {
    public static <T> T getValue(Object obj) {
        return (T) obj;
    }
    public static <T> T getValue(Object obj, Class<T> clazz) {
        return (T) obj;
    }
}