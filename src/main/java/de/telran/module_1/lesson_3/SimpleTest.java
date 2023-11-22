package de.telran.module_1.lesson_3;

public class SimpleTest {
    public static void main(String[] args) {
        HenFactory factory = new HenFactory();
        Hen hen = new MoldovaHen();
        System.out.println(hen.getDescription() + " -> "+hen.getCountOfEggsPerMonf());

        Hen hen1 = factory.getHen("moldova");
        System.out.println(hen1.getDescription() + " -> "+hen1.getCountOfEggsPerMonf());

    }

}

