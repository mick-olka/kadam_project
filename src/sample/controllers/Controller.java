package sample.controllers;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import sample.process.MainStep;
import sample.process.Time;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    public Label timer;
    Timer tm;
    public Rectangle clock;

    boolean isTimerOn = true;

    public void initialize() {
        setTimer();
    }

    void doTickGUI() {
        timer.setText(Time.getTime());
    }

    public void setTimer() {
        tm = new Timer();
        tm.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    MainStep.doStep();
                    doTickGUI();
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
}
