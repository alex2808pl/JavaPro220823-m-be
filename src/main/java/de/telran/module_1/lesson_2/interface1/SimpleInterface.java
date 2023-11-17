package de.telran.module_1.lesson_2.interface1;

public class SimpleInterface {
    public static void main(String[] args) {
        TV tv = new TV();
        CafeMashine cafeMashine = new CafeMashine();
        WashMashine washMashine = new WashMashine();

        RemoteRelation rr = new TV();

        AndroidApp androidApp = new CafeMashine();
        androidApp.install();
        RemoteRelation remoteRelation = new CafeMashine();

        IosApp iosApp = new WashMashine();

        myMethod(new CafeMashine(),  new WashMashine());

    }

    static void myMethod(RemoteRelation remoteRelation, IosApp iosApp) {
        remoteRelation.switchProgram();
        System.out.println(iosApp.sum(3,7,19));

    }

}
