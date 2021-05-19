package sample.controllers;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import sample.process.*;
import sample.process.TaskPackage.Task;
import sample.process.TaskPackage.TasksPerform;
import sample.process.panes.TaskPane;
import sample.process.panes.TaskPerformPane;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    public Button testBtn;
    public VBox tasksBox;
    public VBox teamBox;
    public VBox taskPerformBox;

    public Label timer;
    Timer tm;
    public Rectangle clock;
    public ImageView food_icon;

    public Text population;
    public Text ecology;
    public Text stability;

    boolean isTimerOn = true;

    public void initialize() {      //  здесь функции вывода инфы в GUI
        MainData.initMainData();
        setTimer();

        Task.addTasksToGUI(tasksBox);
        Person.addPersonsToGUI(teamBox);
        TasksPerform.addTasksPerformToGUI(taskPerformBox);

        population.setText(String.valueOf(MainData.getWorldPopulation()));
        ecology.setText(String.valueOf(MainData.getWorldEcology()));
        stability.setText(String.valueOf(MainData.getWorldStability()));
    }

    void doTickGUI() {      //  здесь функции обновления инфы в окне
        timer.setText(Time.getTime());
        population.setText(String.valueOf(MainData.getWorldPopulation()));
        ecology.setText(String.valueOf(MainData.getWorldEcology()));
        stability.setText(String.valueOf(MainData.getWorldStability()));
    }

    public void setTimer() {     //  запустить часы
        tm = new Timer();
        tm.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    MainStep.doStep();  // основная функция
                    doTickGUI();    //  обновить время на часах в окне
                });
            }
        },1000, 1000);
        isTimerOn=true;
    }

    public void stopTimer() {
        tm.cancel();
        isTimerOn=false;
    }

    public void clockClicked() {
        if (isTimerOn) {
            stopTimer();
        } else setTimer();
    }

    public void testBtnPressed() {
        //System.out.println("test");
//        addActionPane();
    }

    public void refreshPerformingTasks() {
        TasksPerform.addTasksPerformToGUI(taskPerformBox);
        System.out.println("Refreshed");
    }

}
