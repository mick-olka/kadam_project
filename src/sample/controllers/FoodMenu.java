package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.process.Item;

import java.io.IOException;

public class FoodMenu {     //  это пока не нужно, как пример будет
    static Stage stage;

//    public static void menuInit(MenuButton foodBox) {
//        Item menuItem;
//        for (int i = 1 ; i <=3 ; i++) {
//            menuItem=new Item(i+"", "i");
//            menuItem.setText(i+" item");
//            foodBox.getItems().add(menuItem);
//            Item finalMenuItem = menuItem;
//            menuItem.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
//                public void handle(ActionEvent e)
//                {
//                    System.out.println(finalMenuItem.getName());
//                }
//            });
//        }
//    }

//    public static void setStage(Stage st) {
//        stage=st;
//    }

//    public static void handleFoodWindow() {
//        final Stage dialog = new Stage();
//        dialog.initModality(Modality.APPLICATION_MODAL);
//        dialog.initOwner(stage);
//        dialog.initModality(Modality.NONE);
//        VBox dialogVbox = new VBox(20);
//        dialogVbox.getChildren().add(new Text("This is a Dialog"));
//        Scene dialogScene = new Scene(dialogVbox, 300, 200);
//        dialog.setScene(dialogScene);
//        dialog.show();
//    }
}
