package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.process.ActionsPerform;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("scenes/sample.fxml"));    // !!! сюда потом menu.fxml вставить
        //FoodMenu.setStage(primaryStage);
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        primaryStage.setTitle("KADAM");
        primaryStage.setOnCloseRequest(t -> {   //  действие на закрытии окна
            Platform.exit();
            System.exit(0);
        });
        primaryStage.setScene(new Scene(root, screenSize.width, screenSize.height));    // окно по размеру экрана
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        ActionsPerform.readAction(1);
        System.out.println(ActionsPerform.tempAction.getText());
        System.out.println(ActionsPerform.tempAction.getPopulation());
        System.out.println(ActionsPerform.tempAction.getEcology());
        //launch(args);
    }

}
