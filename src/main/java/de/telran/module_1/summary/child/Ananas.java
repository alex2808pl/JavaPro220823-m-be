package de.telran.module_1.summary.child;

import de.telran.module_1.summary.Fruit;

import java.util.Arrays;

public class Ananas extends Fruit { //наследование
    private String country;

    public void setCountry(String country) {
        this.country = country;
    }

//    @Override
//    public String toString() {
//        return "Ananas{" +
//                "country='" + country + '\'' +
//                "} " + super.toString();
//    }

        @Override
    public String toString() {
        return "Ananas{" +
                "country='" + country + '\'' +
                "color='" + super.getColor() + '\'' +
//                ", sugar=" + super.getSugar() + // не можем получить default в другом пакете
                ", vitamins=" + Arrays.toString(super.getVitamins()) +
                '}';
    }
}
