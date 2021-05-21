package sample.process;

import sample.process.TaskPackage.TasksPerform;
import sample.process.panes.PersonPane;

public class MainStep {

    public static void doStep() {   // основная функция вызывается каждую секунду в Controller.setTimer
        Time.tick();
        MainData.updateWorldStats();
        TasksPerform.countWorkDay();
    }





}
