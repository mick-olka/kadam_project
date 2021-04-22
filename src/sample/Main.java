package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("scenes/sample.fxml"));    // !!! сюда потом menu.fxml вставить
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        primaryStage.setTitle("KADAM");
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {    // действие на закрытии окна
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        primaryStage.setScene(new Scene(root, screenSize.width, screenSize.height));    // окно по размеру экрана
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {    // main
        launch(args);
    }

}
