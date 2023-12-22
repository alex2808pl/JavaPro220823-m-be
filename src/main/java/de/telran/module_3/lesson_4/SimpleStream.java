package de.telran.module_3.lesson_4;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toUnmodifiableSet;

public class SimpleStream {
    public static void main(String[] args) {
        List<Worker> workers = List.of(
                new Worker("Вася", 2000),
                new Worker("Петя", 1000),
                new Worker("Лена", 1500),
                new Worker("Гриша", 1200),
                new Worker("Сергей", 2500)
        );
        System.out.println(
            workers.stream()
                .mapToInt(worker -> worker.salary)
                .average()
        );

        OptionalDouble avg = workers.stream()
                .mapToInt(worker -> worker.salary)
                .average();
        Double avgDouble = avg.getAsDouble();
//        avg.orElse(0.0); //null -> 0.0
//        avg.getAsDouble();//null

        System.out.println(
                workers.stream()
                        .mapToInt(worker -> worker.salary)
                        .summaryStatistics()
        );

        IntSummaryStatistics statistics = workers.stream()
                .mapToInt(worker -> worker.salary)
                .summaryStatistics();

        // Optional
        Integer nullObj = null;
        if(nullObj!=null)
            System.out.println(nullObj.toString());
        Optional<Integer> optObj = Optional.ofNullable(nullObj);
        System.out.println(optObj.toString());


        // flatMap
        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMap(x -> {
                    if (x % 2 == 0) {
                        return Stream.of(-x, x);
                    }
                    return Stream.empty();
                })
                .forEach(System.out::println);
        System.out.println();


        String[][] arrStr = { {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "o", "y"}};

        List<String> lists = Arrays.stream(arrStr)
                .flatMap(x->Arrays.stream(x))
                .collect(Collectors.toList());
        System.out.println(lists);

        // Убираем ряд
        Arrays.stream(arrStr)
                .filter(el -> !Arrays.stream(el).anyMatch(x->x.contains("a")))
                .flatMap(x->Arrays.stream(x))
                .forEach(System.out::println);

        // --------  Терминальные методы
        System.out.println("--------  Терминальные методы");
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        // == findFirst
        Optional<String> str = givenList.stream()
                .filter(x->!x.contains("c"))
                .findFirst();
        System.out.println(str.get());

        // == findFirst
        System.out.println(
                givenList.stream()
                        .filter(x->!x.contains("c"))
                        .count()
        );

        // == anyMatch
        boolean is = givenList.stream()
                .anyMatch(x -> x.startsWith("b"));
        System.out.println(is);

        // == allMatch
        is = givenList.stream()
                .allMatch(x -> x.startsWith("b"));
        System.out.println(is);

        // == min / max
        System.out.println(givenList.stream()
                .min(String::compareTo));

        System.out.println(givenList.stream()
                        .map(x -> x.length())
                        .max(Comparator.naturalOrder()));

        System.out.println(givenList.stream()
                .max(Comparator.comparingInt(x -> x.length())));

        // == toArray
        String[] arrStr1 = givenList.stream()
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(arrStr1));

        // == collect ====

        // --- toList
        List<String> result = givenList.stream()
                .collect(toList());
        result.add("sss");
        System.out.println(result);

        result = givenList.stream()
                .collect(toUnmodifiableList());
//        result.add("sss"); //UnsupportedOperationException
        System.out.println(result);

        // --- toSet
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> resultSet = listWithDuplicates.stream().collect(toSet());
        System.out.println(resultSet);

        resultSet = givenList.stream().collect(toUnmodifiableSet());
        //resultSet.add("dd"); //UnsupportedOperationException

        // --- toCollection
        result = givenList.stream().collect(toCollection(LinkedList::new));
        System.out.println(result);

        // --- toMap
        Map<String, Integer> resultMap = givenList.stream()
                .collect(toMap(Function.identity(), String::length));
        System.out.println(resultMap);

        //.IllegalStateException
        //  resultMap = listWithDuplicates.stream().collect(toMap(Function.identity(), String::length));

        //выберем любое из этих двух конфликтующих значений
        resultMap = listWithDuplicates.stream()
                .collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));
        System.out.println(resultMap);

        // --- toUnmodifiableMap
        resultMap = givenList.stream()
                .collect(toUnmodifiableMap(Function.identity(), String::length));
        // resultMap.put("foo", 3); //UnsupportedOperationException


        // --- joining
        String resultString = givenList.stream().collect(joining());
        System.out.println(resultString);

        resultString = givenList.stream().collect(joining(" "));
        System.out.println(resultString);

        resultString = givenList.stream().collect(joining(" ", "PRE-", "-POST"));
        System.out.println(resultString);

        // --- counting
        Long resultLong = givenList.stream().collect(counting());
        System.out.println(resultLong);

        // --- summarizingDouble
        DoubleSummaryStatistics resultStat = givenList.stream()
                .collect(summarizingDouble(String::length));
        System.out.println(resultStat);

        // --- averagingDouble
        Double resultDouble = givenList.stream()
                .collect(averagingDouble(String::length));
        System.out.println(resultDouble);

        // --- summingDouble
        resultDouble = givenList.stream()
                .collect(summingDouble(String::length));
        System.out.println(resultDouble);

        // --- maxBy()/minBy()
        Optional<String> resultOpt = givenList.stream()
                .collect(maxBy(Comparator.naturalOrder()));
        System.out.println(resultOpt);

        resultOpt = givenList.stream()
                .collect(minBy(Comparator.naturalOrder()));
        System.out.println(resultOpt);

        // --- groupingBy
        Map<Integer, Set<String>> resultMap1 = givenList.stream()
                .collect(groupingBy(String::length, toSet()));
        System.out.println(resultMap1);

        List<String> list = List.of("bb", "ccc", "dd", "aj", "uiu", "aa", "bb");
        Map<Integer, List<String>> resultMap2 = list.stream()
                .collect(groupingBy(String::length, toList()));
        System.out.println(resultMap2);

        // --- partitioningBy
        Map<Boolean, List<String>> resultMap3 = givenList.stream()
                .collect(partitioningBy(s -> s.length() > 2));
        System.out.println(resultMap3);

        // --- teeing
        List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
        int sum = numbers.stream().collect(teeing(
                minBy(Integer::compareTo), // The first collector
                maxBy(Integer::compareTo), // The second collector
                (min, max) -> min.get()+max.get()// Receives the result from those collectors and combines them
        ));
        System.out.println(sum);










    }
}



@AllArgsConstructor
class Worker {
    String name;
    Integer salary;
}
