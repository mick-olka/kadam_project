package sample.process.panes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import sample.process.MainData;
import sample.process.TaskPackage.Task;
import sample.process.TaskPackage.TasksList;
import sample.process.TaskPackage.TasksPerform;

import java.io.IOException;

public class TaskPane extends Pane {

    public TaskPane() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../scenes/taskPane.fxml"));
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
    Text taskInfo;
    @FXML
    Pane pane;

    public void initialize() {      //  SETTING ACTIONS ON CREATION

        pane.setOnMouseClicked(e -> {
            MainData.setTaskToPerform(TasksList.taskList[(Integer.parseInt(this.getId()))]);
        });

    }

    public void displayTaskInfo(Task data) {
        taskInfo.setText(data.getText());
    }   //  DISPLAY TASK INFO

}