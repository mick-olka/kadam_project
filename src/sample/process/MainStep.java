package sample.process;

public class MainStep {

    public static Region[] world = {new Region("First"), new Region("Second"), new Region("Third")};

    public static void doStep() {   // основная функция вызывается каждую секунду в Controller.setTimer
        Time.tick();
    }





}
