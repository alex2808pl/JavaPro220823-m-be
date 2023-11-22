package de.telran.module_1.lesson_3;

public class MoldovaHen extends Hen{
    MoldovaHen() {
    }

    @Override
    int getCountOfEggsPerMonf() {
        return 20;
    }
    @Override
    public String getDescription() {
        return "My country is Moldova. I get " + getCountOfEggsPerMonf() + " eggs a month";
    }
}