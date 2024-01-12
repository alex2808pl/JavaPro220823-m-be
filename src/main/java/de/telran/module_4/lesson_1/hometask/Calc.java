package de.telran.module_4.lesson_1.hometask;

public class Calc {
    public static void main(String[] args) {
        Operation<Integer, Double> operation = new Operation<>();
        System.out.println(operation.add(11,5));
        System.out.println(operation.div(11,5));


        Oper oper = new Oper();
        System.out.println(oper.add(11,5));
        System.out.println(oper.div(11,5));

    }
}

class Operation<T extends Number, U extends Double> {
    public T add(T arg1, T arg2) {
        return (T) Double.valueOf(arg1.doubleValue() + arg2.doubleValue());
    }

    public U div(T arg1, T arg2) {
        return (U) Double.valueOf(arg1.doubleValue() / arg2.doubleValue());
    }
}

class Oper {
    public <T extends Number> T add(T arg1, T arg2) {
        return (T) Double.valueOf(arg1.doubleValue() + arg2.doubleValue());
    }

    public <T extends Number, U  extends Double> U div(T arg1, T arg2) {
        return (U) Double.valueOf(arg1.doubleValue() / arg2.doubleValue());
    }
}
