package de.telran.module_1.lesson_3;

public class HenFactory {
    public Hen getHen(String country) {
        switch (country.toLowerCase()) {
//            case "polska":
//                return new PolskaHen();
//            case "ukraine":
//                return new UkrainianHen();
            case "moldova":
                return new MoldovaHen();
//            case "germany":
//                return new GermahyHen();
            default:
                return null;

        }
    }
}