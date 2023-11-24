package de.telran.module_1.summary2411;

public interface Donut {
    String addJam();
    default void eat() {
        System.out.println("Мы едим пончик с "+addJam());
    };
}
