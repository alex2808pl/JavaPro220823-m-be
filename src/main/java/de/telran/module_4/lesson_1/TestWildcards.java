package de.telran.module_4.lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestWildcards {
    public static void main(String[] args) {

        // производитель (producer), нужно использовать ? extends T,
        List<BMW> list = new ArrayList<>();
        list.add(new BMW());

        List<? extends  Car> garage = list;
        for (Car car: garage) {
            System.out.println(car);
        }
        //garage.add(new Audi());
        print(garage);

        System.out.println();

        //потребитель (consumer), нужно использовать ? super T.
        List<Car> listBmw = new ArrayList<>();
        listBmw.add(new BMW());

        List<? super  Car> garage2 = listBmw;

//        for (Car car: garage2) {
//            System.out.println(car);
//        }

        addNew(listBmw);
        print(listBmw);

//        garage.add(new BMW());
    }

    static void print(List<? extends  Car> cars) {
        for (Car car: cars) {
            System.out.println(car);
        }
        //Не могу изменять данные
      //  cars.add(new BMW());
    }

    static void addNew(List<? super  Car> cars) {
        cars.add(new Audi());

        //Не ммогу потребялять данные
//        for (Car car: cars) {
//            System.out.println(car);
//        }
    }
}



class Car {
    @Override
    public String toString() {
        return "Я - Car{}";
    }
}

class BMW extends Car {
    @Override
    public String toString() {
        return "Я - BMW{} ";
    }
}

class Audi extends Car {
    @Override
    public String toString() {
        return "Я - Audi{} ";
    }
}


