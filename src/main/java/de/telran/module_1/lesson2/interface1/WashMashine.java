package de.telran.module_1.lesson2.interface1;

public class WashMashine implements RemoteRelation {
    @Override
    public void switchOn() {
        System.out.println("WashMashine включился");
    }

    @Override
    public void switchOff() {
        System.out.println("WashMashine выключился");
    }

    @Override
    public void switchProgram() {
        System.out.println("WashMashine переключила режим стирки");
    }
}
