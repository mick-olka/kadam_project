package sample.process.panes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import sample.process.MainData;
import sample.process.Person;
import sample.process.TaskPackage.Task;
import sample.process.TaskPackage.TasksPerform;

import java.io.IOException;

public class PersonPane extends Pane {

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
    @FXML
    Pane pane;

    public void initialize() {

        pane.setOnMouseClicked(e -> {       //  ON CLICK
            System.out.println(this.getId());
            //  >> START PERFORMING TASK
        });

    }

    public void setPersonInfo(Person data) {
        personInfo.setText(data.getText());
    }

}