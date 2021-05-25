package sample.process.panes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import sample.process.MainData;
import sample.process.Person;
import sample.process.TaskPackage.TasksPerform;

import java.awt.*;
import java.io.IOException;

public class PhoneCallPane extends Pane {

    public Person worker;
    public PhoneCallPane() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../scenes/phoneCallPane.fxml"));
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

    public Person newPerson = new Person();

    public void initialize() {
        MainData.isTimerOn=false;
        setPersonInfo();
    }

    public void setPersonInfo() {
        personInfo.setText(newPerson.getText());
    }


}