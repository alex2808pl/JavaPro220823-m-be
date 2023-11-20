package de.telran.module_1.lesson_2.polimorph;

public class GroomerShop {
    public void cut(Animal animal) {
        System.out.print("Подстригли, животное сказало Спасибо - ");
        animal.voice();
    }


    public void cutClaws(Cat cat) {
        System.out.print("Подстригли когти, животное сказало Спасибо - ");
        cat.krups();
    }

    public int sum (Animal animal) {
        return 10;
    }

    public int sum (Dog dog) {
        return 20;
    }

    public int sum (Dog dog, Cat cat) {
        return 15;
    }

}


//    это возможность работать с несколькими типами так, будто это один и тот же тип.