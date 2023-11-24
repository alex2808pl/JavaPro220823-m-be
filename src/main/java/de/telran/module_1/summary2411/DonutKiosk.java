package de.telran.module_1.summary2411;

public class DonutKiosk {
    public static void main(String[] args) {
        DonutsFactory df = new DonutsFactory();
        Donut donut = df.getInstance(DonutType.CARAMEL);
        donut.eat();
        donut = df.getInstance(DonutType.CHOCOLATE);
        donut.eat();
        donut = df.getInstance(DonutType.CHERRY);
        donut.eat();

        donut = DonutsFactoryStatic.getInstance(DonutType.CARAMEL);
        donut.eat();

        df.getInstance(DonutType.CHOCOLATE).eat();
        DonutsFactoryStatic.getInstance(DonutType.CARAMEL).eat();
    }
}
