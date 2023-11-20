package de.telran.module_1.lesson_2.polimorph;

public class Cat extends Animal{
    @Override
    public void voice() {
        System.out.println("Мау");
    }

    public void voice(String sound) {
        System.out.println("Голос");
    }

    public void krups() {
        System.out.println("Царапаюсь!");
    }
}
