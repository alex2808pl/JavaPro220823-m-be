package de.telran.module_4.lesson_1.hometask;

public class SimpleSendMessage {
    public static void main(String[] args) {
        PrepareData prepareData = new PrepareData();
        String data = prepareData.prepareData(EMail.class);

        SendMessage message = new EMail();
        String report = message.generateReport(data);
        message.sendReport(report);

        data = prepareData.prepareData(Viber.class);
        message = new Viber();
        report = message.generateReport(data);
        message.sendReport(report);

        data = prepareData.prepareData(Telegram.class);
        message = new Telegram();
        report = message.generateReport(data);
        message.sendReport(report);

    }
}

class EMail implements SendMessage {
    @Override
    public String generateReport(String data) {
        return "Report в html для "+this.getClass().getName() + " -> "+data;
    }

    @Override
    public boolean sendReport(String report) {
        System.out.println("Отправили на Email -> "+report);
        return true;
    }
}

class Telegram extends ReportText {
    @Override
    public boolean sendReport(String report) {
        System.out.println("Отправили на Telegram -> "+report);
        return true;
    }
}

class Viber extends ReportText {
    @Override
    public boolean sendReport(String report) {
        System.out.println("Отправили на Viber -> "+report);
        return true;
    }
}

class WhatsApp extends ReportText {
    @Override
    public boolean sendReport(String report) {
        System.out.println("Отправили на WhatsApp -> "+report);
        return true;
    }
}


abstract class ReportText implements SendMessage {
    public String generateReport(String data) {
        return "Report в txt для "+this.getClass().getName() + " -> "+data;
    }

    public abstract boolean sendReport(String report);

}


interface SendMessage {
    String generateReport(String data);
    boolean sendReport(String report);
}

class PrepareData {
    public <T> String prepareData(T canal) {
       return  "Данные для канала "+canal.toString();
        // код генерации отчета + canal
    }
}