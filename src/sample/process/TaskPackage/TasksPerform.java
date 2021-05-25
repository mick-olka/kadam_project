package sample.process.TaskPackage;

import javafx.scene.layout.VBox;
import sample.process.MainData;
import sample.process.Person;
import sample.process.Player;
import sample.process.panes.ChosenTasksPane;

//*************************//
//  CLASS TO PROCESS TASKS //
//*************************//

public class TasksPerform {

    public Task task;
    public int time;
    Person worker = null;

    public static int activeChosenTaskId=0;

    public TasksPerform(Task task) {
        this.task=task;
        this.time=this.task.getTime();
    }

    public void setWorker(Person worker) {
        if (this.worker==null) {
            if (!worker.isWorking) {
                this.worker = worker;
                worker.isWorking = true;
            }
        }
    }

    public static void countWorkDay() {
        TasksPerform performing_task;
        for (int i = 0; i< MainData.chosenTasks.size(); i++) {
            performing_task=MainData.chosenTasks.get(i);
            if (MainData.chosenTasks.get(i).worker != null) {   //  IF HAS WORKER -- COUNT TIME TO COMPLETION
                performing_task.time--;
            }
            if (performing_task.time == 0) {
                performing_task.taskDone(); //  TASK DONE
            }
        }
    }

    //===================================

    public static void updateTasksPerformInGUI(VBox tasksBox) {    //  SHOW CHOSEN TASKS ON PANEL
        tasksBox.getChildren().clear();
        for (int i = 0; i< MainData.chosenTasks.size(); i++) {
            TasksPerform tp = MainData.chosenTasks.get(i);
            ChosenTasksPane newPane = new ChosenTasksPane();
            newPane.setId(String.valueOf(i));
            newPane.setTaskPerformInfo(tp);
            tasksBox.getChildren().add(newPane);
            System.out.println(TasksPerform.activeChosenTaskId==i);
            newPane.setActiveInGUI(TasksPerform.activeChosenTaskId==i);
        }
    }

    //  *****   IMPLEMENTING TASK RESULTS   *****   //
    public void taskDone() {
        this.worker.isWorking=false;
        MainData.chosenTasks.remove(this);
        doTask(this.task);
        if (!MainData.chosenTasks.isEmpty()) activeChosenTaskId=0;
    }

    private static void doTask(Task task) {
        System.out.println("isInstant: "+task.isInstant());
        if (task.isInstant()) {
            if (task.getReg() == -1) {
                for (int i = 0; i < MainData.world.length; i++) updateGameStats(task, i);
            } else updateGameStats(task, task.getReg());
        } else {
            if (task.getReg() == -1) {
                for (int i = 0; i < MainData.world.length; i++) updateGameChangingStats(task, i);
            } else updateGameChangingStats(task, task.getReg());
        }
    }

    private static void updateGameStats(Task ac, int reg) {
        MainData.world[reg].addRegionStats(ac);
        MainData.player.updatePlayerStats(ac);
    }
    private static void updateGameChangingStats(Task ac, int reg) {
        MainData.world[reg].addRegionChangingStats(ac);
        MainData.player.updatePlayerChangingStats(ac);
    }

}
