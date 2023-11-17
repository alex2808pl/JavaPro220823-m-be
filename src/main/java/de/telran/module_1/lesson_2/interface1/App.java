package de.telran.module_1.lesson_2.interface1;

public interface App {
    void install();
    //возвращает пользователя
    default String autorization() {
        return "Я пользователь Noname";
    }

}
