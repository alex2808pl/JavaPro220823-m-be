package de.telran.module_4.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGeneric {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Я люблю ");
        list.add(5);
        list.add(5.5);
        String text = (String) list.get(0); // + "generics";
        System.out.println(text);
        System.out.println(list);
        ((String) list.get(0)).contains("ю");
        ((String) list.get(1)).contains("ю");

        List<String> listStr = new ArrayList();
        listStr.add("Я люблю ");
        //listStr.add(5); //ошибка
        String textStr = listStr.get(0);
    }
}
