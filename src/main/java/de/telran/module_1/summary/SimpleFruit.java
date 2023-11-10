package de.telran.module_1.summary;

public class SimpleFruit {

    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        fruit.setColor("белый");
        fruit.setSugar(16);
        fruit.setVitamins(new String[]{"A", "C"});

        System.out.println(fruit);

        Ananas ananas = new Ananas();
        ananas.setColor("желтый");
        ananas.setSugar(10);
        ananas.setVitamins(new String[]{"A", "B", "C"});
        ananas.setCountry("Уругвай");

//        ananas.constyVal = "Я константа";

        System.out.println(ananas);

    }



}
