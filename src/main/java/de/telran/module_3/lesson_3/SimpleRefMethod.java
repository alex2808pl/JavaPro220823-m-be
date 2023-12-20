package de.telran.module_3.lesson_3;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class SimpleRefMethod {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,3,5,2,8,9);
        list.forEach((el)-> System.out.println(el));
        list.forEach(System.out::println);

        Function<String, Integer> toInteger = string -> parse(string);
        Integer integer = toInteger.apply("5");
        Function<String, Integer> toInteger1 = SimpleRefMethod::parse;
        integer = toInteger1.apply("10");

        BiFunction<String,String,Integer> biFunction = SimpleRefMethod::sum;
        System.out.println(biFunction.apply("11", "5"));

        // Конструктор
        UserFactory userFactory = User::new;
        User user = userFactory.create("John", "Snow");

        BiFunction<String,String,User> userFactory1 = User::new;
        User user1 = userFactory1.apply("John", "Snow");

        Function<String, String> trim = String::trim;
        String str = trim
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" ABCDEFG ");
        System.out.println(str);


    }

    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }

    private static Integer sum (String s1, String s2) {
        return Integer.parseInt(s1)+Integer.parseInt(s2);
    }

}
