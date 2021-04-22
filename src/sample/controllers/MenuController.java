package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    public Button startBtn;

    public void startBtnPressed(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("../scenes/sample.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.setMaximized(true);
        app_stage.setResizable(false);
        app_stage.setMinWidth(home_page_parent.computeAreaInScreen());
        app_stage.setMinHeight(home_page_parent.computeAreaInScreen());
        app_stage.show();
    }
}
