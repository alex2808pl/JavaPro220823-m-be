package de.telran.module_3.lesson_3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("10","20","1", "10", "15", "50", "25");
        System.out.println(list);
        //filter & count
        long c = list.stream()
                .filter(p -> p.equals("10"))
                .count();
        System.out.println("count = "+c);

        //sorted
        List<String> listResult = list.stream()
                .sorted()
                .toList();
        System.out.println(listResult);

        listResult =  list.stream()
                .sorted(String::compareTo)
                .toList();
        System.out.println(listResult);

        //limit
        listResult =  list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .toList();

        System.out.println(listResult);

        //skip
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.sorted().skip(2);
        listResult = stream2.toList(); // stream завершился
        System.out.println(listResult);
//        System.out.println(stream2.count()); // ошибка stream уже завершен

        listResult = list.stream()
                .sorted()
                .skip(2)
                .toList();
        System.out.println(listResult);

        // distinct
        Set<String> setResult = list.stream()
                .distinct()
                .collect(Collectors.toSet());
        System.out.println(setResult);

        //peek
        listResult = list.stream()
                .peek(el -> System.out.println("Element = "+el))
                .toList();
        System.out.println(listResult);

        //map
        list.stream()
                .map(x -> x + " times")
                .forEach(System.out::println);

        // map - изменяем тип потока
        List<Integer> listResultInt = list.stream()
                .map(x -> Integer.parseInt(x))
                .toList();
        System.out.println(listResultInt);

        list.stream()
                .mapToInt(x -> Integer.parseInt(x))
                .forEach(el -> {
                    int sum = el+10;
                    System.out.println(sum);
                });

        // flatMap
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        List list1 = List.of(1,2,3);
        List list2 = Arrays.asList(4,5,6);
        arrayList.add(list1);
        arrayList.add(list2);
        System.out.println(arrayList);

        Optional<Integer> min = arrayList.stream()
                .flatMap(x -> x.stream())
                .peek(System.out::println)
                .min(Integer::compareTo);
        System.out.println(min.get());

    }
}
