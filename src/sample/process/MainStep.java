package sample.process;

public class MainStep {
    public static void doStep() {   // основная функция вызывается каждую секунду в TimeController
        Time.tick();
    }
}
