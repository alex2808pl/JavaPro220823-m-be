package de.telran.module_1.lesson2.interface1;

public class TV implements RemoteRelation{

    @Override
    public void switchOn() {
        System.out.println("Телевизор включился");
    }

    @Override
    public void switchOff() {
        System.out.println("Телевизор выключился");
    }

    @Override
    public void switchProgram() {
        System.out.println("Телевизор переключил канал");
    }
}
