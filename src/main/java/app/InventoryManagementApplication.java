/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InventoryManagementApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(
        Objects.requireNonNull(getClass().getResource("Application.fxml")));

    Scene scene = new Scene(root);

    // set title to "Inventory Manager"
    stage.setTitle("Inventory Manager");
    // set scene
    stage.setScene(scene);
    // set minimum width to 770
    stage.setMinWidth(770);
    // set minimum height to 480
    stage.setMinHeight(480);
    // show stage
    stage.show();
  }

}
