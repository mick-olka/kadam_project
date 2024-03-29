package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("scenes/menu.fxml"));    // !!! сюда потом menu.fxml вставить
        //FoodMenu.setStage(primaryStage);
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        primaryStage.setTitle("KADAM");
        primaryStage.setOnCloseRequest(t -> {   //  действие на закрытии окна
            Platform.exit();
            System.exit(0);
        });
        primaryStage.setScene(new Scene(root));    // окно по размеру экрана
//        primaryStage.setMaximized(true);
//        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        //  тут можно проверять функциональную часть
        launch(args);
    }

}
