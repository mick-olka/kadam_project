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
        //TasksPerform.updateTasksPerformInGUI(taskPerformBox);

        population.setText(String.valueOf(MainData.getWorldPopulation()));
        ecology.setText(String.valueOf(MainData.getWorldEcology()));
        stability.setText(String.valueOf(MainData.getWorldStability()));
    }

    void doTickGUI() {      //  здесь функции обновления инфы в окне
        timer.setText(Time.getTime());
        population.setText(String.valueOf(MainData.getWorldPopulation()));
        ecology.setText(String.valueOf(MainData.getWorldEcology()));
        stability.setText(String.valueOf(MainData.getWorldStability()));
        //updateWorkerGraphics();
        TasksPerform.updateTasksPerformInGUI(taskPerformBox);
        Person.updateTeamPaneInGUI(teamBox);
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
        },1000, 3000);
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
        teamBox.getChildren().get(1).setStyle("-fx-background-color: red");
    }

    public void refreshPerformingTasks() {
        TasksPerform.updateTasksPerformInGUI(taskPerformBox);
        System.out.println("Refreshed");
    }

//    public void updateWorkerGraphics() {
//        for (int i=-1; i<teamBox.getChildren().lastIndexOf(new Pane()); i++) {
//            if (MainData.myTeam.get(i).isWorking) {
//                teamBox.getChildren().get(i).setStyle("-fx-background-color: blue");
//            } else teamBox.getChildren().get(i).setStyle("-fx-background-color: red");
//        }
//    }

}
