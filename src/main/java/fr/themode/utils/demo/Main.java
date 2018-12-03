package fr.themode.utils.demo;

import fr.themode.utils.timer.Timer;

public class Main {

    public static void main(String[] args) {
        new Main();

    }

    public Main() {
        Timer timer = new Timer();

        timer.addRepeatingTask(() -> {
            System.out.println("Test");
        }, 500);

        timer.addTimerTask(() -> {
            System.out.println("RESET");
            timer.reset();
        }, 1000);

        timer.start();

    }

}
