package de.telran.module_2.lesson_4_5;

public class SimpleData {
    public static void main(String[] args) {
        //POJO
        Cat cat1 = new Cat("Мурка", 10, "дворняжка");
        Cat cat2 = cat1;

        System.out.println(cat1 == cat2);
        System.out.println(cat1.equals(cat2));

        Cat cat3 = new Cat("Мурка", 10, "дворняжка");
        System.out.println(cat1 == cat3);
        System.out.println(cat1.equals(cat3));
        System.out.println(cat1.getClass());
        Object obj = cat1;
        System.out.println(obj.getClass());
    }
}
