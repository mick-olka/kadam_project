package sample.process;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.IOException;

public class MyPane extends Pane {

    public MyPane() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../scenes/actionPane.fxml"));
        //FXMLLoader loader = getClass().getResource("../scenes/actionPane.fxml");
        loader.setRoot(this);
        //loader.setController(new ActionPaneController());
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

    public void initialize() {
        pane.setOnMouseClicked(e -> {
            //System.out.println(this.getId());
            TasksPerform.taskDone(Integer.parseInt(this.getId()));
        });
    }

    public void setTaskInfo(Task data) {
        taskInfo.setText(data.getText());
    }

}