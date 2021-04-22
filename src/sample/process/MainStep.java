package sample.process;

import sample.controllers.TimeController;

public class MainStep {
    public static void doStep() {   // основная функция вызывается каждую секунду в TimeController
        Time.tick();
    }
}
