package de.telran.module_4.lesson_1;

public class TestExtends {
    public static void main(String[] args) {
        OnlyNumber o1 = new OnlyNumber<>(5);
        o1.print();

//        OnlyNumber o2 = new OnlyNumber<>("Slon");
//        o2.print();

        OnlyNumber o3 = new OnlyNumber<>(8.5);
        o3.print();

    }
}

class  OnlyNumber<T extends Number> {
    private T number;

    public OnlyNumber(T number) {
        this.number = number;
    }
    public void print() {
        System.out.println(number);
    }
}
