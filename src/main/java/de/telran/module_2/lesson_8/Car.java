package de.telran.module_2.lesson_8;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Car {
    private String number;
    private String name;
    private double price;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car = (Car) o;
//        return Objects.equals(number, car.number);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(number);
//    }
}
