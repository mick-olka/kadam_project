package sample.process.panes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import sample.process.TaskPackage.TasksPerform;

import java.io.IOException;

public class ChosenTasksPane extends Pane {

    public ChosenTasksPane() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../scenes/taskPerformPane.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    //int id = Integer.parseInt(this.getId());

    @FXML
    Circle circle;
    @FXML
    Text taskPerformText;
    @FXML
    Pane pane;

    public void initialize() {
        pane.setOnMouseClicked(e -> {
            System.out.println("activated task: "+this.getId());
            TasksPerform.activeChosenTaskId= Integer.parseInt(this.getId());
        });
    }

    public void setTaskPerformInfo(TasksPerform data) {
        taskPerformText.setText(data.task.getName()+"\n"+data.time+" d");
    }

    public void setActiveInGUI(boolean isAxtive) {
        if (isAxtive) circle.setStyle("-fx-fill: aquamarine");
        else circle.setStyle("-fx-fill: #6acadb");
    }

}