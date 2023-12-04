package de.telran.module_2.lesson_4_5;

import java.util.SortedSet;
import java.util.TreeSet;

public class SimpleTreeSet {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("T");
        sortedSet.add("A");
        sortedSet.add("V");
        sortedSet.add("B");
        System.out.println(sortedSet);
        System.out.println(sortedSet.add("A"));
        System.out.println(sortedSet);
    }
}
