package de.telran.module_6.lesson_2;

public class SimplePilot {
    public static void main(String[] args) {

        ThreadInteraction interaction = new ThreadInteraction();

        Pilot request = new Pilot(interaction);
        Controller response = new Controller(interaction);


    }
}
class ThreadInteraction {
    boolean isActive = false;
    public synchronized void Request(String request){
        if(isActive){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Pilot:");
        System.out.println(request);
        isActive = true;
        notify();
    }

    public synchronized void Response(String response){
        if(!isActive){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Controller:");
        System.out.println(response);
        isActive = false;
        notify();
    }
}

class Pilot implements Runnable {
    ThreadInteraction interaction;
    String[] request =
            {
                    "1. Dnipro Radar, Я борт - Aeroflot 1816",
                    "2. Запрос высоты, Aeroflot 1816",
                    "3. Вас понял, моя высота 6,000 фут, борт - Aeroflot 1816"
            };

    public Pilot(ThreadInteraction interaction) {
        this.interaction = interaction;
        new Thread(this, "Request").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < request.length; i++) {
            interaction.Request(request[i]);
        }
    }
}

class Controller implements Runnable {
    ThreadInteraction interaction;
    String[] response =
            {
                    "1. Aeroflot 1816, Dnipro Radar, подымитесь выше",
                    "2. Aeroflot 1816, вы на высоте 6,000 футов"
            };

    public Controller(ThreadInteraction interaction) {
        this.interaction = interaction;
        new Thread(this, "Response").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < response.length; i++) {
            interaction.Response(response[i]);
        }
    }
}