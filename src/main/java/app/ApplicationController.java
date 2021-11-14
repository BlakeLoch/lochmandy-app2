/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ApplicationController {

  @FXML
  private HBox addBar;

  @FXML
  private Button addConfirm;

  @FXML
  private Button addItem;

  @FXML
  private TextField addName;

  @FXML
  private TextField addSerialNumber;

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
  private TextField editSerialNumber;

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
  private HBox saveBar;

  @FXML
  private Button saveCancel;

  @FXML
  private Button saveHTML;

  @FXML
  private Button saveItems;

  @FXML
  private Button saveJSON;

  @FXML
  private Button saveTSV;

  @FXML
  private HBox searchBar;

  @FXML
  private Button searchDone;

  @FXML
  private Button searchItems;

  @FXML
  private TextField searchName;

  @FXML
  private Button searchNameButton;

  @FXML
  private TextField searchSerialNumber;

  @FXML
  private Button searchSerialNumberButton;

  @FXML
  private TableColumn<?, ?> serialNumberColumn;

  @FXML
  private TableColumn<?, ?> valueColumn;

  private final InventoryManager inventory = new InventoryManager();
  private List<String> activeSerialNumbers = new ArrayList<>();

  @FXML
  void initialize() {

    // bind dataTable to inventory
    // set serialNumberColumn to item serialNumbers
    // set nameColumn to item names
    // set valueColumn to item values

    // When button in removeColumn is clicked
    // remove item's serialNumber from activeSerialNumbers
    // remove item from list
    // remove item from table

    // add all items to dataTable
  }


  //when addItem is clicked
  @FXML
  private void addItemClicked() {
    // hide menuBar
    // show addBar
  }

  //when addConfirm is clicked
  @FXML
  private void addConfirmClicked() {
    // get name from addName
    // get serialNumber from addSerialNumber
    // get value from addValue

    // if validateName(name) is false
    // set errorMessage text to "Invalid Name: Name Must Be Between 2-256 Characters"
    // if validateSerialNumber(serialNumber) is false
    // set errorMessage text to "Invalid Serial Number: Serial Number Must Be In Format A-XXX-XXX-XXX"
    // if validateValue(value) is false
    // set errorMessage text to "Invalid Value: Value Must Be In Format of US Currency (USD)"
    // if activeSerialNumbers contains serialNumber
    // set errorMessage text to "Invalid Serial Number: Serial Number Must Be Unique"
    // else
    // // item = new InventoryItem with name, serialNumber, and value
    // add item to inventory
    // add item to table
    // add serialNumber to activeSerialNumbers
    // clear addName
    // clear addSerialNumber
    // clear addValue
    // hide addBar
    // show menuBar
  }

  //when editItem is clicked
  @FXML
  private void editItemClicked() {
    // hide menuBar
    // show editBar
    // set editName to selected/highlighted item.getName()
    // set editSerialNumber to selected/highlighted item.getSerialNumber()
    // set editValue to selected/highlighted item.getValue()
  }

  //when addConfirm is clicked
  @FXML
  private void editConfirmClicked() {
    // get name from editName
    // get serialNumber from editSerialNumber
    // get value from editValue
    // item = selected item

    // if validateName(name) is false
    // set errorMessage text to "Invalid Name: Name Must Be Between 2-256 Characters"
    // if validateSerialNumber(serialNumber) is false
    // set errorMessage text to "Invalid Serial Number: Serial Number Must Be In Format A-XXX-XXX-XXX"
    // if validateValue(value) is false
    // set errorMessage text to "Invalid Value: Value Must Be In Format of US Currency (USD)"
    // if activeSerialNumbers contains serialNumber
    // set errorMessage text to "Invalid Serial Number: Serial Number Must Be Unique"
    // else
    // if name != item's name
    // set item name to name
    // if serialNumber != item's serialNumber
    // remove item's serialNumber from activeSerialNumbers
    // set item serialNumber to serialNumber
    // add serialNumber to activeSerialNumbers
    // if value != item's value
    // set item value to value
    // clear editName
    // clear editSerialNumber
    // clear editValue
    // hide editBar
    // show menuBar
  }

  // when clearItems is clicked
  @FXML
  private void clearItemsClicked() {
    // clear inventory
    // clear dataTable
    // clear activeSerialNumbers
  }

  // when saveItems is clicked
  @FXML
  private void saveItemsClicked() {
    // hide menuBar
    // show saveBar
  }

  // when saveTSV is clicked
  @FXML
  private void saveTSVClicked() {
    // create a fileChooser
    // set title to "Save Inventory"
    // open fileChooser
    // if file is selected
    // inventory.saveInventory(outputFile, TSV)
    // hide saveBar
    // show menuBar
  }

  // when saveHTML is clicked
  @FXML
  private void saveHTMLClicked() {
    // create a fileChooser
    // set title to "Save Inventory"
    // open fileChooser
    // if file is selected
    // inventory.saveInventory(outputFile, HTML)
    // hide saveBar
    // show menuBar
  }

  // when saveJSON is clicked
  @FXML
  private void saveJSONClicked() {
    // create a fileChooser
    // set title to "Save Inventory"
    // open fileChooser
    // if file is selected
    // inventory.saveInventory(outputFile, JSON)
    // hide saveBar
    // show menuBar
  }

  // when saveCancel is clicked
  @FXML
  private void saveCancelClicked() {
    // hide saveBar
    // show menuBar
  }

  // when loadItems is clicked
  @FXML
  private void loadItemsClicked() {
    // create a fileChooser
    // set title to "Load Inventory"
    // set to only take txt, html, or json files
    // open fileChooser and choose inputFile
    // if file is selected
    // clear inventory
    // clear dataTable
    // clear activeSerialNumbers
    // add items to inventory
    // add items to dataTable
    // for each item
    // add serialNumber to activeSerialNumbers
  }

  // when searchItems is clicked
  @FXML
  private void searchItemsClicked() {
    // hide menuBar
    // show searchBar
  }

  // when searchDone is clicked
  @FXML
  private void searchDoneClicked() {
    // clear searchName
    // clear searchSerialNumber
    // set table to all items
    // hide searchBar
    // show menuBar
  }

  // when searchNameButton is clicked
  @FXML
  private void searchNameButtonClicked() {
    // get name from searchName
    // filteredList = new ArrayList
    // for each item
    // if item.getName() contains or equals name
    // add item to filteredList
    // populate dataTable with filteredList
  }

  // when searchSerialNumberButton is clicked
  @FXML
  private void searchSerialNumberButtonClicked() {
    // get serialNumber from searchName
    // filteredList = new ArrayList
    // for each item
    // if item.getSerialNumber() contains or equals serialNumber
    // add item to filteredList
    // populate dataTable with filteredList
  }




}
