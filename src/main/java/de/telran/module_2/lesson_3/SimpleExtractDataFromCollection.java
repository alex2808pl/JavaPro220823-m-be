package de.telran.module_2.lesson_3;

import java.util.Iterator;
import java.util.List;

public class SimpleExtractDataFromCollection {
    public static void main(String[] args) {
        List<Integer> intLists = List.of(1,7,3,6,2,5,9);

        //стандартный механизм
        for (int i = 0; i < intLists.size(); i++) {
            System.out.println(intLists.get(i));
        }
        System.out.println();

        //foreach
        for (int el : intLists) {
            System.out.println(el);
        }
        System.out.println();

        // stream foreach
        intLists.stream().forEach(o -> System.out.println(o));
        System.out.println();
        intLists.forEach(o -> System.out.println(o));
        System.out.println();
        intLists.forEach(System.out::println);

        System.out.println("Iterator");
        //Iterator
        Iterator<Integer> iterator = intLists.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
