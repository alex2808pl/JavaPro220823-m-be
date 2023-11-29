package de.telran.module_2.lesson_2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SimpleLinkedList {
    public static void main(String[] args) {
        List<String> myStringList = new LinkedList<>();
        myStringList.add("Январь");
        myStringList.add("Февраль");
        myStringList.add("Март");

        for (String s : myStringList) {
//            System.out.print(s+",");
            s=s+"!"; // изменения не работают через foreach
        }
        System.out.println();
        System.out.println(myStringList);

        for (int i = 0; i < myStringList.size(); i++) {
            String s = myStringList.get(i);
            myStringList.set(i, s+"!");
        }

//        myStringList.addFirst("Декабрь");
//        myStringList.addLast("Декабрь");

        System.out.println(myStringList);

        // Все тоже самое что в ArrayList
        myStringList.clear();
        System.out.println(myStringList);

        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.addFirst("Один"); //Работает только в 21 java
        System.out.println(linkedList);

        Deque<String> deque =  new LinkedList<>();
        deque.addFirst("Один");
        System.out.println(deque);
    }
}
