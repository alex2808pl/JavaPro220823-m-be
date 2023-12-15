package de.telran.module_3.lesson_1;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class SimpleFun {
    public static void main(String[] args) {


//        simpleDoWork(new SimpleFunClass());

//        simpleDoWork(new SimpleFunInterface() {
//            @Override
//            public void doWork(int inParam) {
//                System.out.println("Anonymus:doWork "+inParam);
//            }
//
//            @Override
//            public void beep() {
//
//            }
//        });

        simpleDoWorkMy((in) -> System.out.println("Lambda:doWork "+in));

        // Consumer

        simpleDoWork((k) -> System.out.println("Consumer Lambda:accept "+k));

        simpleDoWork(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Consumer Anonymous:accept "+integer);
            }
        });


        // BiConsumer
        simpleDoWorkBi((i,s) -> System.out.println("BiConsumer "+i+" , "+s));

        simpleDoWorkBi(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer i, String s) {
                System.out.println("BiConsumer Anonymous "+i+" , "+s);
            }
        });

    }

    public static void simpleDoWorkMy(SimpleFunInterface si) {
        si.doWork(6);
    }

    public static void simpleDoWork(Consumer<Integer> si) {
        si.accept(6);
    }

    public static void simpleDoWorkBi(BiConsumer<Integer, String> si) {
        si.accept(6, "Test");
    }
}

class SimpleFunotherClass implements SimpleFunInterface {
    @Override
    public void doWork(int inParam) {
        System.out.println("SimpleFunClass:doWork "+inParam);
    }

    @Override
    public void beep() {

    }
}
