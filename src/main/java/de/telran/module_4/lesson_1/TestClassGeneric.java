package de.telran.module_4.lesson_1;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class TestClassGeneric {
    public static void main(String[] args) {
        Test testObj = new Test();
        testObj.set(55);
        System.out.println(testObj);

        Test<String> testStr = new Test<>();
        testStr.set("Ура!");
        System.out.println(testStr);
        System.out.println(testStr.get());

        Test<List<Integer>> testList = new Test<>();
        testList.set(Arrays.asList(1,2,3,4,5));
        System.out.println(testList.get());

        // не рекомендуется
        Test<int[]> testArrInt = new Test<>();
        int[] arrInt = {5,4,3,2};
        testArrInt.set(arrInt);
        System.out.println(Arrays.toString(testArrInt.get()));

        Test2<Integer, Integer> test2 = new Test2(0);
        System.out.println(test2.get());
        System.out.println(test2.getObj2());

        Test2<String, Integer> test21 = new Test2(0);
    }
}

class Test<T> {
    T obj;
    void set(T obj)  {
        this.obj = obj;
    }

    T get() {
        return obj;
    }
}


class Test2<T,U> {
    T obj;
    U obj2;

    void set(T obj)  {
        this.obj = obj;
    }

    T get() {
        return obj;
    }

    public Test2(U obj2) {
        this.obj2 = obj2;
    }

    public Test2() {
    }

    U getObj2() {
        return obj2;
    }

    U getObj2(T t) {
        return (U)t;
    }


}