package de.telran.module_2.lesson_2;

import java.util.ArrayList;
import java.util.List;

public class SimpleArrayList {
    public static void main(String[] args) {
        List myList = new ArrayList(); // List<Object> - лучше не использовать
        myList.add("Я строка");
        myList.add(1);
        myList.add(true);
        System.out.println(myList);

        List<Integer> myIntList = new ArrayList<>();
        myIntList.add(1);
        myIntList.add(2);
        myIntList.add(5);
        myIntList.add(3);
        //myIntList.add("Zffgg"); // не корректный тип данных
        System.out.println(myIntList);
        System.out.println(myIntList.size());
        myIntList.add(2, 33);
        System.out.println(myIntList);
        myIntList.set(1,22);
        System.out.println(myIntList);
        System.out.println(myIntList.get(4));
        System.out.println(myIntList.contains(33));
        System.out.println(myIntList.contains(333));
        System.out.println(myIntList.indexOf(33));
        System.out.println(myIntList.indexOf(333));

        ArrayList<Integer> myInt2 = new ArrayList<>();
        myInt2.add(6);
        myInt2.add(18);
        myIntList.addAll(myInt2);
        System.out.println(myIntList);

        // удаление
//        System.out.println(myIntList.remove((Object)55));
        System.out.println(myIntList.remove((Integer)55));
        System.out.println(myIntList.remove((Integer)33));
        System.out.println(myIntList);
        System.out.println(myIntList.remove(8));
        System.out.println(myIntList);
//        myIntList.addFirst(10); //Работает только в 21 java
        System.out.println(myIntList);

    }
}
