package de.telran.module_2.lesson_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleCar {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("AE1111BE", "Mazda 6", 10_000));
        carList.add(new Car("AE2222BE", "Audi", 8_000));
        carList.add(new Car("AE3333BE", "Lada", 4_000));
        carList.add(new Car("AE4444BE", "Lanos", 3_000));

        String findCarNumber = "AE3333BE";

        // O(n)
        for (Car car : carList) {
            if (car.getNumber().equalsIgnoreCase(findCarNumber)){
                System.out.println(car);
                break;
            }
        }

        // O(1) - если нет коллизии
        Map<String, Car> carMap = new HashMap<>();
        for (Car car : carList) {
            carMap.put(car.getNumber(), car);
        }
        System.out.println(carMap.get(findCarNumber));

        // Ключи и значение - объектные типы
        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(new Cargo("A1", "B1", 3));
        cargoList.add(new Cargo("A2", "B2", 5));
        cargoList.add(new Cargo("A3", "B3", 8));
        cargoList.add(new Cargo("A4", "B4", 4));

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getNumber().equalsIgnoreCase(findCarNumber)){
                System.out.println(carList.get(i) + " ====> "+cargoList.get(i));
                break;
            }
        }


        Map<Car, Cargo> carCargoMap = new HashMap<>();

        for (int i = 0; i < carList.size(); i++) {
            carCargoMap.put(carList.get(i),cargoList.get(i));
        }
        System.out.println(carCargoMap);

        Car findAuto = new Car("AE3333BE", "BMW", 4_000);

        System.out.println(carCargoMap.get(findAuto));

        System.out.println(carCargoMap.keySet());



    }
}

