package de.telran.module_1.lesson_2.abstract1;

public class SimpleAnimal {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.rest();
        cat.run();
        cat.voice();

        Dog dog = new Dog();
        dog.rest();
        dog.run();
        dog.voice();

        Rino rino = new Rino();
        rino.rest();
        rino.run();
        rino.voice();
    }
}
