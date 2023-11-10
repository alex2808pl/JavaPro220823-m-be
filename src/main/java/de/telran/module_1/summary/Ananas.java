package de.telran.module_1.summary;

import java.util.Arrays;

public class Ananas extends Fruit { //наследование

    public final String constyVal;
    private String country;

    public Ananas() {
        super();
        this.constyVal = "Начальное";
        System.out.println("Ananas()"+this.getClass());
    }

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
                ", sugar=" + super.getSugar() +
                ", vitamins=" + Arrays.toString(super.getVitamins()) +
                '}';
    }
}
