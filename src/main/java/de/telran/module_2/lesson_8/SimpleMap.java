package de.telran.module_2.lesson_8;

import java.util.*;

public class SimpleMap {
    public static void main(String[] args) {
        Map<Integer, String> mapHash = new HashMap<>();
        mapHash.put(2,"Вася");
        mapHash.put(5,"Петя");
        mapHash.put(1,"Дуся");
        mapHash.put(8,"Лена");
        mapHash.put(4,"Гриша");
        System.out.println(mapHash);

        Map<Integer, String> mapLinked = new LinkedHashMap<>();
        mapLinked.put(2,"Вася");
        mapLinked.put(5,"Петя");
        mapLinked.put(1,"Дуся");
        mapLinked.put(8,"Лена");
        mapLinked.put(4,"Гриша");
        System.out.println(mapLinked);

        Map<Integer, String> mapTree = new TreeMap<>();
        mapTree.put(2,"Вася");
        mapTree.put(5,"Петя");
        mapTree.put(1,"Дуся");
        mapTree.put(8,"Лена");
        mapTree.put(4,"Гриша");
        System.out.println(mapTree);

        Map<Integer, String> mapTree2 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });

        mapTree2.putAll(mapTree);
        System.out.println(mapTree2);

        // Извлечение значение по ключу
        System.out.println(mapHash.get(4));
        System.out.println(mapLinked.get(4));
        System.out.println(mapTree.get(4));

        mapHash.put(4, "Федя"); // поменяю value

        // Перебор значений
        for (Map.Entry<Integer, String> entry : mapHash.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+" = "+value);
        }

        System.out.println("---- Iterator ---------");
        Iterator<Map.Entry<Integer, String>> iterator = mapHash.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> element = iterator.next();
            Integer key = element.getKey();
            String value = element.getValue();
            System.out.println(key+" = "+value);
        }

        // Ключи
        Set<Integer> keys = mapHash.keySet();
        System.out.println(keys);
        //Значения
        List<String> values = new ArrayList<>(mapHash.values());
        System.out.println(values);

        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(mapHash.entrySet());
        System.out.println(entryList);

        // Сортировка
        entryList.sort(new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return String.CASE_INSENSITIVE_ORDER.compare(o2.getValue(), o1.getValue());
            }
        });
        System.out.println(entryList);

        // Можем сортировать только по ключу
        SortedMap<Integer, String> sortedMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        System.out.println(sortedMap.isEmpty());
        sortedMap.putAll(mapHash);
        System.out.println(sortedMap);
        System.out.println(sortedMap.isEmpty());
        System.out.println(sortedMap.size());
    }
}
