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

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Application.fxml")));

    Scene scene = new Scene(root);

    stage.setTitle("Inventory Manager");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
