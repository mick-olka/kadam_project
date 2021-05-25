package sample.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import sample.process.*;
import sample.process.TaskPackage.Task;
import sample.process.TaskPackage.TasksPerform;
import sample.process.panes.PhoneCallPane;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    public Button testBtn;
    public VBox tasksBox;
    public VBox teamBox;
    public VBox taskPerformBox;

    public Label timer;
    public Rectangle clock;
    public ImageView food_icon;

    public Text population;
    public Text ecology;
    public Text stability;
    public Text coins;
    public Label region0;
    public Label region1;
    public Label region2;

    public Button acceptBtn;
    public Button declineBtn;

    public AnchorPane root;

    public ProgressBar stabilityProgressBar;

    private PhoneCallPane callPane;

    public void initialize() {      //  здесь функции вывода инфы в GUI
        MainData.initMainData();
        setTimer();

        Task.addTasksToGUI(tasksBox);
        Person.addPersonsToGUI(teamBox);
        //TasksPerform.updateTasksPerformInGUI(taskPerformBox);

        population.setText(String.valueOf(MainData.getWorldPopulation()));
        ecology.setText(String.valueOf(MainData.getWorldEcology()));
        stability.setText(String.valueOf(MainData.getWorldStability()));

        region0.setText(MainData.world[0].name);
        region1.setText(MainData.world[1].name);
        region2.setText(MainData.world[2].name);

        acceptBtn.setVisible(false);
        declineBtn.setVisible(false);
    }

    void doTickGUI() {      //  здесь функции обновления инфы в окне
        timer.setText(Time.getTime());
        population.setText(String.valueOf(MainData.getWorldPopulation()));
        ecology.setText(String.valueOf(MainData.getWorldEcology()));
        stability.setText(String.valueOf(MainData.getWorldStability()));
        stabilityProgressBar.setProgress(MainData.getWorldStability()*0.01);

        coins.setText(String.valueOf(MainData.player.getCoins()));
        //updateWorkerGraphics();
        TasksPerform.updateTasksPerformInGUI(taskPerformBox);
        Person.updateTeamPaneInGUI(teamBox);
    }

    public void setTimer() {     //  запустить часы
        MainData.tm = new Timer();
        MainData.tm.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (MainData.isTimerOn) {
                        MainStep.doStep();  // основная функция
                        doTickGUI();    //  обновить время на часах в окне
                    }
                });
            }
        },1000, 3000);
        MainData.isTimerOn=true;
    }

    public void toggleClock() {
        MainData.isTimerOn= !MainData.isTimerOn;
    }

    public void testBtnPressed() {

    }

    public void showPhoneCall() {
        acceptBtn.setVisible(true);
        declineBtn.setVisible(true);
        callPane = new PhoneCallPane();
        callPane.setId("callPane");
        root.getChildren().add(callPane);
    }

    public void acceptBtnPressed() {
        MainData.myTeam.add(callPane.newPerson);
        closePhoneCall();
        refreshTeamPane();
        acceptBtn.setVisible(false);
        declineBtn.setVisible(false);
    }

    public void declineBtnPressed() {
        closePhoneCall();
        acceptBtn.setVisible(false);
        declineBtn.setVisible(false);
    }

    public void closePhoneCall() {
        root.getChildren().remove(callPane);
    }

    public void refreshPerformingTasks() {
        TasksPerform.updateTasksPerformInGUI(taskPerformBox);
        //System.out.println("Refreshed");
    }

    public void refreshTeamPane() {
        Person.updateTeamPaneInGUI(teamBox);
        //System.out.println("Refreshed");
    }

}
