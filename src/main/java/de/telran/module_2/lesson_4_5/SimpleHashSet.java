package de.telran.module_2.lesson_4_5;

import java.util.*;

public class SimpleHashSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(5); //Integer.hashCode(5);
        set.add(2);
        set.add(1);
        set.add(8);
        System.out.println(set);

        System.out.println();

        Set<Integer> setLink = new LinkedHashSet<>();
        setLink.add(5);
        setLink.add(2);
        setLink.add(1);
        setLink.add(8);
        System.out.println(setLink);

        int h = Integer.MAX_VALUE;
        System.out.println(h);
        h = h + 1;
        System.out.println(h);
        h = Integer.MIN_VALUE;
        System.out.println(h);
        System.out.println(h-1);

        Set<Cat> cats = new HashSet<>();
        cats.add(new Cat("Мурка", 5, "дворняжка"));
        cats.add(new Cat("Барсик>", 8, "шотландец"));
        cats.add(new Cat("Миша", 10, "британец"));
        cats.add(new Cat("Зося", 3, "перс"));
        System.out.println(cats);

        cats.add(new Cat("Миша", 10, "британец"));
        System.out.println(cats);

        // Без Comparator с этим типом списка мы работать не можем
//        SortedSet<Cat> catsTree = new TreeSet<>();
//        catsTree.add(new Cat("Мурка", 5, "дворняжка"));
//        catsTree.add(new Cat("Барсик>", 8, "шотландец"));
//        catsTree.add(new Cat("Миша", 10, "британец"));
//        catsTree.add(new Cat("Зося", 3, "перс"));
//        System.out.println(cats);

        Set<Cat> catsLink = new LinkedHashSet<>();
        catsLink.add(new Cat("Мурка", 5, "дворняжка"));
        catsLink.add(new Cat("Барсик>", 8, "шотландец"));
        catsLink.add(new Cat("Миша", 10, "британец"));
        catsLink.add(new Cat("Зося", 3, "перс"));
        System.out.println(catsLink);

        Iterator<Cat> iterator = catsLink.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Cat cat : catsLink) {
            System.out.println(cat);
        }
    }

}
