package de.telran.module_1.summary2411.singleton;

public class SimpleGate {
    public static void main(String[] args) {
        Gate gate = Gate.getInstance(123);
        Gate gate1 = Gate.getInstance(123);

        System.out.println(gate == gate1);
        System.out.println(gate.equals(gate1));
        System.out.println(gate);
        System.out.println(gate1);

        System.out.println();

        GateEnum gateEnum = GateEnum.INSTANCE;
        GateEnum gateEnum1 = GateEnum.INSTANCE;
        System.out.println(gateEnum == gateEnum1);
        System.out.println(gateEnum.equals(gateEnum1));
        System.out.println(gateEnum.hashCode());
        System.out.println(gateEnum1.hashCode());
    }
}

