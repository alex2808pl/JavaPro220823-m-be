package de.telran.module_2.lesson_6;

import de.telran.module_2.lesson_4_5.Cat;

import java.util.*;

public class SimpleCompare {
    public static void main(String[] args) {
        SortedSet<Cat> catsTree = new TreeSet<>();
        catsTree.add(new Cat("Мурка", 5, "дворняжка"));
        catsTree.add(new Cat("Мурка", 5, "мэйнкун"));
        catsTree.add(new Cat("Барсик>", 8, "шотландец"));
        catsTree.add(new Cat("Миша", 10, "британец"));
        catsTree.add(new Cat("Зося", 3, "перс"));
        catsTree.add(new Cat("Васька", 8, "сфинкс"));
        System.out.println(catsTree);

        SortedSet<Cat> cats = new TreeSet<>(new NameCatComparator());
        cats.add(new Cat("Мурка", 5, "дворняжка"));
        cats.add(new Cat("Мурка", 5, "мэйнкун")); //потерялась из-за логики сравнения в компараторе
        cats.add(new Cat("Барсик>", 8, "шотландец"));
        cats.add(new Cat("Миша", 10, "британец"));
        cats.add(new Cat("Зося", 3, "перс"));
        cats.add(new Cat("Васька", 8, "сфинкс"));
        System.out.println(cats);

        System.out.println(" --- List -----");
        List<Cat> catList = new ArrayList<>(catsTree);
        System.out.println(catList);
        catList.sort(new NameCatComparator());
        System.out.println(catList);


        //Анонимный класс в качестве компаратора
        catList.sort(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return Integer.compare(o2.getAge(),o1.getAge()); //обратный порядок сортировки
            }
        });
        System.out.println(catList);

        //Другой вид реализации компаратора через анонимный  класс
        Comparator<Cat> catComparator = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return Integer.compare(o1.getAge(),o2.getAge());
            }
        };
        catList.sort(catComparator);
        System.out.println(catList);

        // Реализация компаратора через лямбда выражение
        Comparator<Cat> catComparatorLambda = ((o1, o2) -> o2.getName().compareTo(o1.getName()));
        catList.sort(catComparatorLambda);
        System.out.println(catList);

        // Реализация компаратора через comparing
        Comparator<Cat> catComparatorComparing = Comparator.comparing(Cat::getAge);
        catList.sort(catComparatorComparing);
        System.out.println(catList);

        // обратная сортировка через comparing
        catList.sort(Comparator.comparing(Cat::getAge).reversed());
        System.out.println(catList);

        // прямая сортировка через comparing
        catList.sort(Comparator.comparing(Cat::getAge));
        System.out.println(catList);

        catList.sort(Comparator.comparing(Cat::getAge).thenComparing(Cat::getName).thenComparing(Cat::getBreed));
        System.out.println(catList);




//        if(this.age < o.age) // основное сравнение по name
//            return -1;
//        else if(this.age > o.age)
//            return 1;
//        else {
//            int res = this.name.compareTo(o.name); // вложенное сравнение по name
//            if(res == 0) {
//                return this.breed.compareTo(o.breed); //// вложенное сравнение по breed
//            }
//            else
//                return res;
//        }

    }
}

class NameCatComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getName().compareTo(o2.getName());
    }
}