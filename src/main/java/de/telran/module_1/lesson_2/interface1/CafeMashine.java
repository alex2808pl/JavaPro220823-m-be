package de.telran.module_1.lesson_2.interface1;

public class CafeMashine implements RemoteRelation, AndroidApp {

    @Override
    public void switchOn() {
        System.out.println("CafeMashine включился");
    }

    @Override
    public void switchOff() {
        System.out.println("CafeMashine выключился");
    }

    @Override
    public void switchProgram() {
        System.out.println("CafeMashine выбрала напиток");
    }

    @Override
    public void install() {
        System.out.println("install Android "+FREE_PAY);
    }
}
