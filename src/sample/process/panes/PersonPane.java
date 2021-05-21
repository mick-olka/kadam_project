package sample.process.panes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import sample.process.MainData;
import sample.process.Person;
import sample.process.TaskPackage.Task;
import sample.process.TaskPackage.TasksPerform;

import java.io.IOException;

public class PersonPane extends Pane {

    public Person worker;
    public PersonPane() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../scenes/personPane.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    @FXML
    Circle testCircle;
    @FXML
    Text personInfo;
    public Pane pane;

    public void initialize() {

        pane.setOnMouseClicked(e -> {       //  ON CLICK
            if (!MainData.chosenTasks.isEmpty()) {
                if (!MainData.myTeam.get(Integer.parseInt(this.getId())).isWorking) {
                    //  BIND WORKER TO ACTIVE CHOSEN TASK
                    MainData.chosenTasks.get(TasksPerform.activeChosenTaskId).setWorker(MainData.myTeam.get(Integer.parseInt(this.getId())));
                    System.out.println("Worker " + this.getId() + " set to task " + TasksPerform.activeChosenTaskId);
                } else {
                    pane.setStyle("-fx-background-color: red");
                }
            }
        });
    }

    public void setPersonInfo(Person data) {
        personInfo.setText(data.getText());
    }

    public void checkGraphicState() {
        int id  = Integer.parseInt(this.getId());
        Person worker = MainData.myTeam.get(id);
        if (worker.isWorking) {
            pane.setStyle("-fx-background-color: blue");
        } else pane.setStyle("-fx-background-color: red");
    }

}