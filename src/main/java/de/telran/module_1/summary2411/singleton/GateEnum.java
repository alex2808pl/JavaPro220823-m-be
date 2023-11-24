package de.telran.module_1.summary2411.singleton;

public enum GateEnum {
    INSTANCE(123); // public static GateEnum INSTANCE = new GateEnum(123);

    private double radioGerz;

    private GateEnum(double radioGerz) {
        this.radioGerz = radioGerz;
    }

    public void openGate() {
        System.out.println("Двери открываются ->"+radioGerz);
    }

    public void closeGate() {
        System.out.println("Двери закрываются ->"+radioGerz);
    }
}
