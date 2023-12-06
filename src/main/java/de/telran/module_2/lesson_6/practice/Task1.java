package de.telran.module_2.lesson_6.practice;

import de.telran.module_2.lesson_4_5.Cat;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Мурка", 5, "дворняжка"));
        cats.add(new Cat("Мурка", 5, "мэйнкун"));
        cats.add(new Cat("Барсик>", 8, "шотландец"));
        cats.add(new Cat("Миша", 10, "британец"));
        cats.add(new Cat("Зося", 3, "перс"));
        cats.add(new Cat("Васька", 8, "сфинкс"));
        System.out.println(cats);
        Comparator<Cat> catComparable = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                int res;
                if(o1.getAge()>o2.getAge()) res = 1;
                else if (o1.getAge()<o2.getAge()) res = -1;
                else {
                    res =  o1.getName().compareTo(o2.getName());
                }
                return res;
            }
        };
        cats.sort(catComparable);
        System.out.println(cats);

        // Другая реализация
        cats.sort(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                if(o1.getAge()>o2.getAge()) return 1;
                if (o1.getAge()<o2.getAge()) return -1;
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(cats);

        cats.sort(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                int res = Integer.compare(o1.getAge(), o2.getAge());
                if (res != 0)
                    return res;
                else
                    return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(cats);

    }
}

// Задача: у нас есть ArrayList котов, содержащий такие поля: имя, год рождения, вес и тд.
//         нам нужно отсортировать массив на основе года рождения, а если год одинаковый то по имени.
//Способ 2. - использование Comparator Interface
