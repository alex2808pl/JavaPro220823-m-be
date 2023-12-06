package de.telran.module_2.lesson_4_5;

import java.util.Objects;

public class Cat implements Comparable<Cat>{
    private String name;
    private int age;
    private String breed;

    public Cat() {
    }

    public Cat(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name) && Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, breed);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        if(this.age < o.age) // основное сравнение по name
            return -1;
        else if(this.age > o.age)
            return 1;
        else {
            int res = this.name.compareTo(o.name); // вложенное сравнение по name
            if(res == 0) {
                return this.breed.compareTo(o.breed); //// вложенное сравнение по breed
            }
            else
                return res;
        }
    }
}
