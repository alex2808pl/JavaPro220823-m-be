package de.telran.module_4.lesson_2;

import java.util.function.Function;

public class MathOperation<T extends Number> {

    public double add(T a, T b) {
        double d = a.doubleValue() + b.doubleValue();
        return d;
    }

    public T add(T a, T b, Function<Double,T> function) {
        double d = a.doubleValue() + b.doubleValue();
        return function.apply(d);
    }

    public static void main(String[] args) {
        MathOperation<Integer> obj = new MathOperation<>();
        System.out.println(obj.add(5, 7, x-> x.intValue()));

        Calc calc = new Calc();
        System.out.println(calc.add(25, 13));

        NumberCalculator<Integer, Double> nc = new Calc1<>();
        System.out.println(nc.add(5, 5));
        System.out.println(nc.div(5, 2));

        Calc2<Integer, Double> calc2 = new Calc2<>();
        System.out.println(calc2.add(10, 12));
        System.out.println(calc2.div(10, 2));
        double i = Double.valueOf(12.5);
    }
}

interface NumberCalculator<T extends Number, U> {
    T add(T arg1, T arg2); //добавление
    T sub(T arg1, T arg2); //вычитание
    T mult(T arg1, T arg2); //умножение
    U div(T arg1, T arg2); //деление
    T sqr(T arg1, T arg2); //получение квадрата
}

class Calc2<T extends Number, U extends Double> {
    public T add(T arg1, T arg2) {
        return (T) Double.valueOf(arg1.doubleValue()+arg1.doubleValue());
    }

    public U div(T arg1, T arg2) {
        return (U) Double.valueOf(arg1.doubleValue()/arg1.doubleValue());
    }
}

class Calc1<T extends Number> implements  NumberCalculator<T, Double> {

    @Override
    public T add(T arg1, T arg2) {
        return (T) Double.valueOf(arg1.doubleValue()+arg1.doubleValue());
    }

    @Override
    public T sub(T arg1, T arg2) {
        return null;
    }

    @Override
    public T mult(T arg1, T arg2) {
        return null;
    }

    @Override
    public Double div(T arg1, T arg2) {
        return Double.valueOf(arg1.doubleValue()/arg1.doubleValue());
    }

    @Override
    public T sqr(T arg1, T arg2) {
        return null;
    }
}

class Calc implements  NumberCalculator<Number, Double> {

    @Override
    public Number add(Number num1, Number num2) {
        return num1.doubleValue()+num2.doubleValue();
    }

    @Override
    public Number sqr(Number num1, Number num2) {
        return num1.doubleValue()*num2.doubleValue();
    }

    @Override
    public Double div(Number num1, Number num2) {
        return num1.doubleValue()/num2.doubleValue();
    }

    @Override
    public Number mult(Number num1, Number num2) {
        return num1.doubleValue()*num2.doubleValue();
    }

    @Override
    public Number sub(Number num1, Number num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}