package de.telran.module_1.summary2411;

public class DonutsFactory {
    public Donut getInstance(DonutType type) {
        Donut returnDonat = null;
        switch (type) {
            case CHERRY:
                returnDonat = new CherryDonut();
                break;
            case CHOCOLATE:
                returnDonat = new ChocolateDonut();
                break;
            case CARAMEL:
                returnDonat = new CaramelDonut();
        }
        return returnDonat;
    }

}
