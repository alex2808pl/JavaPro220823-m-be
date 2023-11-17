package de.telran.module_1.lesson_2;

public class Simple {
    public static void main(String[] args) {
        Test t = new Test();
        t.meth1();

        Test t1 = new Test(10);
        t1.meth1();
    }
}

class Test extends TestDad{
    Test() {
        System.out.println("Test()");
    }

    Test(int par1) {
        super(par1);
        System.out.println("Test(int par1)");
    }
}

class TestDad {

    private int par;

    TestDad() {
        System.out.println("TestDad()");
    }

    TestDad(int par) {
        System.out.println("TestDad(par) "+par);
        this.par = par;
    }

    void meth1() {
        System.out.println(par+22);
    }
}
