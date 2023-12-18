package de.telran.module_3.lesson_2;

import de.telran.module_1.lesson_2.abstract1.Dog;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.*;

import de.telran.module_2.lesson_8.Car;

public class SimpleStandartFunctionInt {
    public static void main(String[] args) {
        // boolean ???? (T t)
        // температура, при которой можно ходить в школу
        Predicate<Integer> predicate = (temperature) -> (temperature < -30) ? false : true;
        Predicate<Integer> predicate2 = (temperature) -> temperature > -30;
        System.out.println(predicate2.test(-15));
        System.out.println(predicate2.test(-31));
        predicate2 = (weight) -> weight < 15; // грузоподьемность моста
        System.out.println(predicate2.test(10));
        System.out.println(predicate2.test(20));

        // boolean ???? (T t, U u)
        BiPredicate<Integer,Double> biPredicate = (i, d) -> i >= d;
        System.out.println(biPredicate.test(4, 4.0001));

        // void accept(T t);
        Consumer<Integer> consumer = (t) -> System.out.println((t>15)?"тепло":"холодно");
        consumer.accept(18);
        consumer.accept(0);

        //void accept(T t, U u);
        BiConsumer<Integer, Integer> biConsumer =
                (weight, auto)-> System.out.println((weight>auto)?"не перевезет":"перевезем");
        biConsumer.accept(10, 5);
        biConsumer.accept(10, 20);

        // T get();
        Supplier<String> supplier = () -> {
            Car car = new Car("1111AD","BMW", 10_000);
            return car.getName();
        };
        System.out.println("Auto ->" + supplier.get());

        supplier = () -> "Мама мыла раму";
        System.out.println(supplier.get());

        // R apply(T t);
        Function<Integer, String> function = (i) -> String.format("Температура воздуха = %d 'C", i);
        System.out.println(function.apply(15));

        // R apply(T t, U u);
        BiFunction<Integer, Double, String> biFunction = (w, k) ->
                (w <=k )? "садись, поехали": "извините, мы не можем Вас покатать на этой качеле";
        System.out.println(biFunction.apply(100, 80.5));
        System.out.println(biFunction.apply(100, 110.5));

        //T apply(T t);
        UnaryOperator<Integer> unaryOperator = (i) -> i*i;
        System.out.println("Квадрат числа 5 равно "+unaryOperator.apply(5));


        List<Integer> lists = List.of(1,2,3,4,5,6);
        System.out.println(lists);
        lists.forEach((e)-> System.out.print(e+", "));

        System.out.println();
        lists.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer e) {
                System.out.print(e+", ");
            }
        });

    }


}
