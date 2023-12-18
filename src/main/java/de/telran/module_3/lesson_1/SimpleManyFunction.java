package de.telran.module_3.lesson_1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SimpleManyFunction {

    public static void main(String[] args) {
        Dog dog1 = new Dog("Тузик", 10, "двортерьер");
        dog1.printCallName("Фас");
        dog1.printAge("Сколько лет? ");
        dog1.getPrice("Вася ");

        MyFuncInterface int1 = new MyFuncInterface() {
            @Override
            public void printCall(Dog dog, String call) {
                System.out.println(call+" "+dog.getName());
            }
        };
        int1.printCall(dog1, "Фас");

        MyFuncInterface int2 = (dog, call) -> System.out.println(call+" "+dog.getName());
        int2.printCall(dog1, "Фас");

        MyFuncInterface int3 = (dog, call) ->  System.out.println(call+" "+dog.getAge());;
        int3.printCall(dog1,"Сколько лет? ");

        int3 = (dog, call) -> System.out.println(call+" "+dog.getBreed());
        int3.printCall(dog1,"Какая порода? ");

        int3 = (dog, call) -> {
            int price = dog.getAge() * 10;
            System.out.println(call + "может продать "+dog.getName()+" за "+ price + " евро");
        };
        int3.printCall(dog1,"Петя ");

        sendEmail(dog1, "Петя ", int3);

        sendEmail(dog1, "Фас ", int2);
    }

    static void sendEmail(Dog dog, String message, MyFuncInterface body) {
        System.out.print("Мы отправляем по почте сообщение: ");
        body.printCall(dog, message);
    }

}

interface MyFuncInterface {
    void printCall(Dog dog, String call);
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
class Dog {
    private String name;
    private int age;
    private String breed;

    public void printCallName(String call) {
        System.out.println(call+" "+name);
    }

    public void printAge(String call) {
        System.out.println(call+" "+age);
    }

    public void getBreed(String call) {
        System.out.println(call+" "+breed);
    }

    public void getPrice(String namePeople) {
        int price = age * 10;
        System.out.println(namePeople + "может продать "+name+" за "+ price + "евро");
    }
}