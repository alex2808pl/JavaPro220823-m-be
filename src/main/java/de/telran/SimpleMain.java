package de.telran;

import de.telran.module_1.lesson_1.Cat;

import java.util.*;
import java.util.function.Function;

import java.time.temporal.ValueRange;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.summarizingDouble;

public class SimpleMain {
    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        // --- toList
        List<String> result = givenList.stream()
                .collect(toList());
        result.add("sss");
        System.out.println(result);

        result = givenList.stream()
                .collect(toUnmodifiableList());
        //result.add("sss"); //UnsupportedOperationException
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

        resultMap = givenList.stream()
                .collect(toMap(Function.identity(), String::length));

        //.IllegalStateException
        // resultMap = listWithDuplicates.stream().collect(toMap(Function.identity(), String::length));

        //выберем любое из этих двух конфликтующих значений
        resultMap = listWithDuplicates.stream()
                .collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));
        System.out.println(resultMap);

        // --- toUnmodifyingMap
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

        // --- partitioningBy
        Map<Boolean, List<String>> resultMap2 = givenList.stream()
                .collect(partitioningBy(s -> s.length() > 2));
        System.out.println(resultMap2);

        List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
        int sum = numbers.stream().collect(teeing(
                minBy(Integer::compareTo), // The first collector
                maxBy(Integer::compareTo), // The second collector
                (min, max) -> min.get()+max.get()// Receives the result from those collectors and combines them
        ));
        System.out.println(sum);

    }
}
