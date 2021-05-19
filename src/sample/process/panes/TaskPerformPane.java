package sample.process.panes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import sample.process.TaskPackage.Task;
import sample.process.TaskPackage.TasksPerform;

import java.io.IOException;

public class TaskPerformPane extends Pane {

    public TaskPerformPane() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../scenes/taskPerformPane.fxml"));
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
    Text taskPerformText;
    @FXML
    Pane pane;

    public void initialize() {
//        pane.setOnMouseClicked(e -> {
//            System.out.println(this.getId());
//            TasksPerform.taskDone(Integer.parseInt(this.getId()));
//        });
    }

    public void setTaskPerformInfo(Task data) {
        taskPerformText.setText(data.getText());
    }

}