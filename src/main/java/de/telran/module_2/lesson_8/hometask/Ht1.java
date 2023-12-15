package de.telran.module_2.lesson_8.hometask;

import java.util.HashMap;
import java.util.Map;

public class Ht1 {
    public static void main(String[] args) {
        Map<String, String> routeMap = new HashMap<>();
        routeMap.put("Berlin","London");
        routeMap.put("Tokyo","Seoul");
        routeMap.put("Mumbai","Berlin");
        routeMap.put("Seoul","Mumbai");
//        routeMap.put("Mumbai","Seoul"); // зацикливание
//        routeMap.put("London","Tokyo");

        Map<String, String> reverseRouteMap = new HashMap<>();
        for( Map.Entry<String, String> el : routeMap.entrySet())  {
            reverseRouteMap.put(el.getValue(), el.getKey());
        }
        String start = null;
        for( Map.Entry<String, String> el : routeMap.entrySet())  {
            if(!reverseRouteMap.containsKey(el.getKey())) {
                start = el.getKey();
                break;
            }
        }

        String toCity = routeMap.get(start);
        while (toCity!=null) {
            System.out.println(start+" -> "+toCity);
            start = toCity;
            toCity = routeMap.get(toCity);
        }
//
//        for (int i = 0; i < routeMap.size(); i++) {
//            System.out.println(start+" -> "+toCity);
//            start = toCity;
//            toCity = routeMap.get(toCity);
//        }

    }
}

/*
1) Найти маршрут из заданного списка билетов
        Учитывая список билетов, найти маршрут по порядку, используя данный список.
        Вход:
        «Berlin» -> «London»
        «Tokyo» -> «Seoul»
        «Mumbai» -> «Berlin»
        «Seoul» -> «Mumbai»
        Выход:
        Tokyo->Seoul, Seoul->Mumbai, Mumbai->Berlin, Berlin->Lindon*/
