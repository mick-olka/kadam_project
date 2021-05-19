package sample.process.TaskPackage;

import javafx.scene.layout.VBox;
import sample.process.MainData;
import sample.process.Person;
import sample.process.panes.TaskPerformPane;

//*************************//
//  CLASS TO PROCESS TASKS //
//*************************//

public class TasksPerform {

    Task task;
    int time;
    Person worker = null;
    public TasksPerform(Task task) {
        this.task=task;
        this.time=this.task.getTime();
    }

    public void setWorker(Person worker) {
        this.worker=worker;
    }


    public static void countWorkDay() {
        TasksPerform performing_task;
        for (int i = 0; i< MainData.chosenTasks.size(); i++) {
            performing_task=MainData.chosenTasks.get(i);
            if (MainData.chosenTasks.get(i).worker != null) {
                performing_task.time--;
            }
            if (performing_task.time == 0) {
                performing_task.taskDone();
            }
        }
    }

    //===================================

    public static void addTasksPerformToGUI(VBox tasksBox) {    //  SHOW CHOSEN TASKS ON PANEL
        tasksBox.getChildren().clear();
        for (int i = 0; i< MainData.chosenTasks.size(); i++) {
            TaskPerformPane newPane = new TaskPerformPane();
            newPane.setId(String.valueOf(i));
            newPane.setTaskPerformInfo(MainData.chosenTasks.get(i).task);
            tasksBox.getChildren().add(newPane);
        }
    }

    //  *****   IMPLEMENTING TASK RESULTS   *****   //
    public void taskDone() {
        doTask(this.task);
    }

    private static void doTask(Task ac) {
        if (ac.getReg()==-1) {
            for (int i = 0; i< MainData.world.length; i++) updateWorldStats(ac, i);
        } else updateWorldStats(ac, ac.getReg());
    }

    private static void updateWorldStats(Task ac, int reg) {
        MainData.world[reg].updateWorldStats(ac);
    }
    private static void updateWorldChangingStats(Task ac, int reg) {
        MainData.world[reg].updateWorldChangingStats(ac);
    }

}
