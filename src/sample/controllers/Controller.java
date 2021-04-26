package sample.controllers;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import sample.process.MainStep;
import sample.process.Time;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    public Label timer;
    Timer tm;
    public Rectangle clock;
    public ImageView food_icon;
    public AnchorPane dialog;   //  тест мини-окон для действий по типу покушать

    boolean isTimerOn = true;

    public void initialize() {
        setTimer();
        dialog.setVisible(false);   //  спрятать мини-окно
        }

    void doTickGUI() {
        timer.setText(Time.getTime());
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

    public void showFoodWindow() {
        dialog.setVisible(true);
    }

    public void hideFoodWindow() {
        dialog.setVisible(false);
    }

}
