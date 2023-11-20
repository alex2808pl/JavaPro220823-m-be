package de.telran.module_1.lesson_2.polimorph.interface1;

public class PizzaEngine implements Customer, Pizzeola, Courier{
    @Override
    public void orderPizza() {
        System.out.println("Заказал Pizza");
    }

    @Override
    public void eatPizza() {
        System.out.println("Съел Pizza");
    }

    @Override
    public void cookIngredients() {
        System.out.println("Порезал и приготовил ингридиенты.");
    }

    @Override
    public void cookPizza() {
        System.out.println("Испек пиццу");
    }

    @Override
    public void deliveryPizza() {
        System.out.println("Доставил пиццу неважно чем");
    }

    @Override
    public void packPizza() {
        System.out.println("Упаковал в картонную коробку");
    }
}

// orderPizza
// cookIngredients
// cookPizza
// deliveryPizza
// packPizza
// eatPizza
