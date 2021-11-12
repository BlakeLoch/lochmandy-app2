/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ApplicationController {

  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private HBox addBar;

  @FXML
  private Button addConfirm;

  @FXML
  private Button addItem;

  @FXML
  private TextField addName;

  @FXML
  private TextField addSerialNo;

  @FXML
  private TextField addValue;

  @FXML
  private Button clearItems;

  @FXML
  private TableView<?> dataTable;

  @FXML
  private HBox editBar;

  @FXML
  private Button editConfirm;

  @FXML
  private Button editItem;

  @FXML
  private TextField editName;

  @FXML
  private TextField editSerialNo;

  @FXML
  private TextField editValue;

  @FXML
  private Label errorMessage;

  @FXML
  private Button loadItems;

  @FXML
  private HBox menuBar;

  @FXML
  private TableColumn<?, ?> nameColumn;

  @FXML
  private TableColumn<?, ?> removeColumn;

  @FXML
  private Button saveItems;

  @FXML
  private HBox searchBar;

  @FXML
  private Button searchConfirm;

  @FXML
  private Button searchItems;

  @FXML
  private TextField searchName;

  @FXML
  private TextField searchSerialNo;

  @FXML
  private TableColumn<?, ?> serialNoColumn;

  @FXML
  private TableColumn<?, ?> valueColumn;

  @FXML
  void initialize() {
  }

}
