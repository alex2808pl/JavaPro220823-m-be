package de.telran.module_1.summary;

import java.util.Arrays;

public class Fruit {
    private String color;
    private int sugar;
    private String[] vitamins;

    public Fruit() {
        System.out.println("Fruit()"+this.getClass());
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setVitamins(String[] vitamins) {
        this.vitamins = vitamins;
    }

    protected String getColor() {
        return color;
    }

    int getSugar() {
        return sugar;
    }

    public String[] getVitamins() {
        return vitamins;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "color='" + color + '\'' +
                ", sugar=" + sugar +
                ", vitamins=" + Arrays.toString(vitamins) +
                '}';
    }
}
