package de.telran.module_1.lesson_2.polimorph.interface1;

import java.util.ArrayList;

public class SimplePizza {
    public static void main(String[] args) {
        PizzaEngine pizzaEngine = new PizzaEngine();
        pizzaEngine.orderPizza();
        pizzaEngine.cookPizza();
        pizzaEngine.eatPizza();
        pizzaEngine.packPizza();

        Customer customer = pizzaEngine; //new PizzaEngine();
        customer.orderPizza();
        customer.eatPizza();

        Pizzeola pizzeola = pizzaEngine;
        pizzeola.cookPizza();
        pizzeola.cookIngredients();
        pizzeola.eatPizza();

        Courier courier = pizzaEngine;
        courier.packPizza();
        courier.deliveryPizza();

    }
}
