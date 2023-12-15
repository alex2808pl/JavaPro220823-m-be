package de.telran.test;

public class SimpleTest {
    public static void main(String[] args) {
        UserFactory userFactory = User::new;
        User user = userFactory.create("John", "Snow");
        System.out.println(user);
    }
}

class User {
    String name, surname;

    User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

interface UserFactory {
    User create(String name, String surname);
}
