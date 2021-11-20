/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

import app.importedclasses.ActionButtonTableCell;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

public class ApplicationController {

  private static final String SAVE_INVENTORY = "Save Inventory";
  private final InventoryManager inventory = new InventoryManager();
  private final List<String> activeSerialNumbers = new ArrayList<>();
  @FXML
  private Button sortName;
  @FXML
  private Button sortSerialNumber;
  @FXML
  private Button sortValue;
  @FXML
  private HBox addBar;
  @FXML
  private HBox editBar;
  @FXML
  private HBox menuBar;
  @FXML
  private HBox saveBar;
  @FXML
  private HBox searchBar;
  @FXML
  private HBox sortBar;
  @FXML
  private Label errorMessage;
  @FXML
  private TextField addName;
  @FXML
  private TextField addSerialNumber;
  @FXML
  private TextField addValue;
  @FXML
  private TextField editName;
  @FXML
  private TextField editSerialNumber;
  @FXML
  private TextField editValue;
  @FXML
  private TextField searchName;
  @FXML
  private TextField searchSerialNumber;
  @FXML
  private TableView<InventoryItem> dataTable;
  @FXML
  private TableColumn<InventoryItem, String> nameColumn;
  @FXML
  private TableColumn<InventoryItem, Button> removeColumn;
  @FXML
  private TableColumn<InventoryItem, String> serialNumberColumn;
  @FXML
  private TableColumn<InventoryItem, String> valueColumn;

  @FXML
  private void initialize() {
    // bind dataTable to inventory
    // set serialNumberColumn to item serialNumbers
    serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
    // set nameColumn to item names
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    // set valueColumn to item values
    valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

    // When button in removeColumn is clicked
    removeColumn.setCellFactory(ActionButtonTableCell.forTableColumn("X", (InventoryItem item) -> {
      // remove item's serialNumber from activeSerialNumbers
      activeSerialNumbers.remove(item.getSerialNumber());
      // remove item from list
      inventory.remove(item);
      // remove item from table
      dataTable.getItems().remove(item);
      // return item
      return item;
    }));

    // add all items to dataTable
    dataTable.getItems().setAll(inventory.getInventory());

    // add all serialNumbers to activeSerialNumbers
    for (InventoryItem item : inventory.getInventory()) {
      activeSerialNumbers.add(item.getSerialNumber());
    }

    // set custom comparator for valueColumn
    Comparator<String> valueCompare = (s1, s2) -> {
      double d1 = Double.parseDouble(s1.substring(s1.indexOf("$") + 1));
      double d2 = Double.parseDouble(s2.substring(s2.indexOf("$") + 1));
      return Double.compare(d1, d2);
    };
    valueColumn.setComparator(valueCompare);

    // set default sort to reverse
    nameColumn.setComparator(nameColumn.getComparator().reversed());
    serialNumberColumn.setComparator(serialNumberColumn.getComparator().reversed());
    valueColumn.setComparator(valueColumn.getComparator().reversed());

  }


  //when addItem is clicked
  @FXML
  private void addItemClicked() {
    // hide menuBar
    menuBar.setVisible(false);
    // show addBar
    addBar.setVisible(true);
  }

  //when addConfirm is clicked
  @FXML
  private void addConfirmClicked() {
    // get name from addName
    String name = addName.getText();
    // get serialNumber from addSerialNumber
    String serialNumber = addSerialNumber.getText();
    // get value from addValue
    String value = addValue.getText();

    // if validateName(name) is false
    if (!InventoryItem.validateName(name)) {
      // set errorMessage text to "Invalid Name: Name Must Be Between 2-256 Characters"
      errorMessage.setText("Invalid Name: Name Must Be Between 2-256 Characters");
      // show errorMessage
      errorMessage.setVisible(true);
    }
    // if validateSerialNumber(serialNumber) is false
    else if (!InventoryItem.validateSerialNumber(serialNumber)) {
      // set errorMessage text to "Invalid Serial Number: Serial Number Must Be In Format A-XXX-XXX-XXX"
      errorMessage.setText("Invalid Serial Number: Serial Number Must Be In Format A-XXX-XXX-XXX");
      // show errorMessage
      errorMessage.setVisible(true);
    }
    // if validateValue(value) is false
    else if (!InventoryItem.validateValue(value)) {
      // set errorMessage text to "Invalid Value: Value Must Be In Format of US Currency (USD)"
      errorMessage.setText("Invalid Value: Value Must Be In Format of US Currency (USD)");
      // show errorMessage
      errorMessage.setVisible(true);
    }
    // if activeSerialNumbers contains serialNumber
    else if (activeSerialNumbers.contains(serialNumber)) {
      // set errorMessage text to "Invalid Serial Number: Serial Number Must Be Unique"
      errorMessage.setText("Invalid Serial Number: Serial Number Must Be Unique");
      // show errorMessage
      errorMessage.setVisible(true);
    }
    // else
    else {
      // item = new InventoryItem with name, serialNumber, and value
      InventoryItem item = new InventoryItem(name, serialNumber, value);
      // add item to inventory
      inventory.add(item);
      // add item to table
      dataTable.getItems().add(item);
      // add serialNumber to activeSerialNumbers
      activeSerialNumbers.add(serialNumber);
      // clear addName
      addName.clear();
      // clear addSerialNumber
      addSerialNumber.clear();
      // clear addValue
      addValue.clear();
      // hide errorMessage
      errorMessage.setVisible(false);
      // hide addBar
      addBar.setVisible(false);
      // show menuBar
      menuBar.setVisible(true);
    }
  }

  //when addCancel is clicked
  @FXML
  private void addCancelClicked() {
    // hide menuBar
    addBar.setVisible(false);
    // show addBar
    menuBar.setVisible(true);
    // clear addName
    addName.clear();
    // clear addSerialNumber
    addSerialNumber.clear();
    // clear addValue
    addValue.clear();
    // hide errorMessage
    errorMessage.setVisible(false);
  }

  //when editItem is clicked
  @FXML
  private void editItemClicked() {
    // hide menuBar
    menuBar.setVisible(false);
    // show editBar
    editBar.setVisible(true);

    InventoryItem item = dataTable.getSelectionModel().getSelectedItem();
    // set editName to selected/highlighted item.getName()
    editName.setText(item.getName());
    // set editSerialNumber to selected/highlighted item.getSerialNumber()
    editSerialNumber.setText(item.getSerialNumber());
    // set editValue to selected/highlighted item.getValue()
    editValue.setText(item.getValue());
  }

  //when editConfirm is clicked
  @FXML
  private void editConfirmClicked() {
    // get name from editName
    String name = editName.getText();
    // get serialNumber from editSerialNumber
    String serialNumber = editSerialNumber.getText();
    // get value from editValue
    String value = editValue.getText();
    // item = selected item
    InventoryItem item = dataTable.getSelectionModel().getSelectedItem();

    // if validateName(name) is false
    if (!InventoryItem.validateName(name)) {
      // set errorMessage text to "Invalid Name: Name Must Be Between 2-256 Characters"
      errorMessage.setText("Invalid Name: Name Must Be Between 2-256 Characters");
      // show errorMessage
      errorMessage.setVisible(true);
    }
    // if validateSerialNumber(serialNumber) is false
    else if (!InventoryItem.validateSerialNumber(serialNumber)) {
      // set errorMessage text to "Invalid Serial Number: Serial Number Must Be In Format A-XXX-XXX-XXX"
      errorMessage.setText("Invalid Serial Number: Serial Number Must Be In Format A-XXX-XXX-XXX");
      // show errorMessage
      errorMessage.setVisible(true);
    }
    // if validateValue(value) is false
    else if (!InventoryItem.validateValue(value)) {
      // set errorMessage text to "Invalid Value: Value Must Be In Format of US Currency (USD)"
      errorMessage.setText("Invalid Value: Value Must Be In Format of US Currency (USD)");
      // show errorMessage
      errorMessage.setVisible(true);
    }
    // if activeSerialNumbers contains serialNumber
    else if (activeSerialNumbers.contains(serialNumber) && !item.getSerialNumber()
        .equals(serialNumber)) {
      // set errorMessage text to "Invalid Serial Number: Serial Number Must Be Unique"
      errorMessage.setText("Invalid Serial Number: Serial Number Must Be Unique");
      // show errorMessage
      errorMessage.setVisible(true);
    }
    // else
    else {
      // if name != item's name
      if (!item.getName().equals(name)) {
        // set item name to name
        item.setName(name);
      }
      // if serialNumber != item's serialNumber
      if (!item.getSerialNumber().equals(serialNumber)) {
        // remove item's serialNumber from activeSerialNumbers
        activeSerialNumbers.remove(item.getSerialNumber());
        // set item serialNumber to serialNumber
        item.setSerialNumber(serialNumber);
        // add serialNumber to activeSerialNumbers
        activeSerialNumbers.add(serialNumber);
      }
      // if value != item's value
      if (!item.getValue().equals(value)) {
        // set item value to value
        item.setValue(value);
      }
      //refresh table
      dataTable.refresh();
      // clear editName
      editName.clear();
      // clear editSerialNumber
      editSerialNumber.clear();
      // clear editValue
      editValue.clear();
      // hide errorMessage
      errorMessage.setVisible(false);
      // hide editBar
      editBar.setVisible(false);
      // show menuBar
      menuBar.setVisible(true);
    }
  }

  //when editCancel is clicked
  @FXML
  private void editCancelClicked() {
    // hide menuBar
    editBar.setVisible(false);
    // show addBar
    menuBar.setVisible(true);
    // clear editName
    editName.clear();
    // clear editSerialNumber
    editSerialNumber.clear();
    // clear editValue
    editValue.clear();
    // hide errorMessage
    errorMessage.setVisible(false);
  }

  // when clearItems is clicked
  @FXML
  private void clearItemsClicked() {
    // clear inventory
    inventory.clear();
    // clear dataTable
    dataTable.getItems().clear();
    // clear activeSerialNumbers
    activeSerialNumbers.clear();
  }

  // when saveItems is clicked
  @FXML
  private void saveItemsClicked() {
    // hide menuBar
    menuBar.setVisible(false);
    // show saveBar
    saveBar.setVisible(true);
  }

  // when saveTSV is clicked
  @FXML
  private void saveTSVClicked() {
    // create a fileChooser
    FileChooser fileChooser = new FileChooser();
    // set title to "Save Inventory"
    fileChooser.setTitle(SAVE_INVENTORY);
    // open fileChooser
    File outputFile = fileChooser.showSaveDialog(dataTable.getScene().getWindow());
    // if file is selected
    if (outputFile != null) {
      // inventory.saveInventory(outputFile, TSV)
      inventory.saveInventory(outputFile, "TSV");
      // hide saveBar
      saveBar.setVisible(false);
      // show menuBar
      menuBar.setVisible(true);
    }
  }

  // when saveHTML is clicked
  @FXML
  private void saveHTMLClicked() {
    // create a fileChooser
    FileChooser fileChooser = new FileChooser();
    // set title to "Save Inventory"
    fileChooser.setTitle(SAVE_INVENTORY);
    // open fileChooser
    File outputFile = fileChooser.showSaveDialog(dataTable.getScene().getWindow());
    // if file is selected
    if (outputFile != null) {
      // inventory.saveInventory(outputFile, HTML)
      inventory.saveInventory(outputFile, "HTML");
      // hide saveBar
      saveBar.setVisible(false);
      // show menuBar
      menuBar.setVisible(true);
    }
  }

  // when saveJSON is clicked
  @FXML
  private void saveJSONClicked() {
    // create a fileChooser
    FileChooser fileChooser = new FileChooser();
    // set title to "Save Inventory"
    fileChooser.setTitle(SAVE_INVENTORY);
    // open fileChooser
    File outputFile = fileChooser.showSaveDialog(dataTable.getScene().getWindow());
    // if file is selected
    if (outputFile != null) {
      // inventory.saveInventory(outputFile, JSON)
      inventory.saveInventory(outputFile, "JSON");
      // hide saveBar
      saveBar.setVisible(false);
      // show menuBar
      menuBar.setVisible(true);
    }
  }

  // when saveCancel is clicked
  @FXML
  private void saveCancelClicked() {
    // hide saveBar
    saveBar.setVisible(false);
    // show menuBar
    menuBar.setVisible(true);
  }

  // when loadItems is clicked
  @FXML
  private void loadItemsClicked() {
    // create a fileChooser
    FileChooser fileChooser = new FileChooser();
    // set title to "Load Inventory"
    fileChooser.setTitle("Load List");
    // set to only take txt, html, or json files
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT, HTML, or JSON",
        "*.txt", "*.html", "*.json");
    fileChooser.getExtensionFilters().add(extFilter);
    // open fileChooser and choose inputFile
    File inputFile = fileChooser.showOpenDialog(dataTable.getScene().getWindow());
    // if file is selected
    if (inputFile != null) {
      // clear inventory
      inventory.clear();
      // clear dataTable
      dataTable.getItems().clear();
      // clear activeSerialNumbers
      activeSerialNumbers.clear();
      // add items to inventory
      inventory.loadInventory(inputFile);
      // add items to dataTable
      dataTable.getItems().setAll(inventory.getInventory());
      // add all serialNumbers to activeSerialNumbers
      for (InventoryItem item : inventory.getInventory()) {
        activeSerialNumbers.add(item.getSerialNumber());
      }
    }
  }

  // when searchItems is clicked
  @FXML
  private void searchItemsClicked() {
    // hide menuBar
    menuBar.setVisible(false);
    // show searchBar
    searchBar.setVisible(true);
  }

  // when searchDone is clicked
  @FXML
  private void searchDoneClicked() {
    // clear searchName
    searchName.clear();
    // clear searchSerialNumber
    searchSerialNumber.clear();
    // set table to all items
    dataTable.getItems().setAll(inventory.getInventory());
    // hide searchBar
    searchBar.setVisible(false);
    // show menuBar
    menuBar.setVisible(true);
  }

  // when searchNameButton is clicked
  @FXML
  private void searchNameButtonClicked() {
    // get name from searchName
    String name = searchName.getText();
    // filteredList = new ArrayList
    List<InventoryItem> filteredList = new ArrayList<>();
    // for each item
    for (InventoryItem item : inventory.getInventory()) {
      // if item.getName() contains or equals name
      if (item.getName().toLowerCase().contains(name.toLowerCase()) || item.getName()
          .equalsIgnoreCase(name)) {
        // add item to filteredList
        filteredList.add(item);
      }
    }
    // populate dataTable with filteredList
    dataTable.getItems().setAll(filteredList);
  }

  // when searchSerialNumberButton is clicked
  @FXML
  private void searchSerialNumberButtonClicked() {
    // get serialNumber from searchSerialNumber
    String serialNumber = searchSerialNumber.getText();
    // filteredList = new ArrayList
    List<InventoryItem> filteredList = new ArrayList<>();
    // for each item
    for (InventoryItem item : inventory.getInventory()) {
      // if item.getSerialNumber() contains or equals serialNumber
      if (item.getSerialNumber().contains(serialNumber) || item.getSerialNumber()
          .equals(serialNumber)) {
        // add item to filteredList
        filteredList.add(item);
      }
    }
    // populate dataTable with filteredList
    dataTable.getItems().setAll(filteredList);
  }

  // when sortItems is clicked
  @FXML
  private void sortItemsClicked() {
    // hide menuBar
    menuBar.setVisible(false);
    // show sortBar
    sortBar.setVisible(true);

  }

  // when sortDone is clicked
  @FXML
  private void sortDoneClicked() {
    // hide menuBar
    menuBar.setVisible(true);
    // show sortBar
    sortBar.setVisible(false);
  }

  @FXML
  void sortNameClicked() {
    // reverse comparator
    nameColumn.setComparator(nameColumn.getComparator().reversed());
    // sort column
    dataTable.getSortOrder().setAll(nameColumn);
    // hide sort triangle
    nameColumn.setSortNode(new Group());

    // if sortName is showing "Name (D)"
    if (sortName.getText().equals("Name (D)")) {
      // show "Name (A)"
      sortName.setText("Name (A)");
      //else
    } else {
      // show "Name (D)"
      sortName.setText("Name (D)");
    }

  }

  @FXML
  void sortSerialNumberClicked() {
    // reverse comparator
    serialNumberColumn.setComparator(serialNumberColumn.getComparator().reversed());
    // sort column
    dataTable.getSortOrder().setAll(serialNumberColumn);
    // hide sort triangle
    serialNumberColumn.setSortNode(new Group());

    // if sortSerialNumber is showing "Serial Number (D)"
    if (sortSerialNumber.getText().equals("Serial Number (D)")) {
      // show "Serial Number (A)"
      sortSerialNumber.setText("Serial Number (A)");
      //else
    } else {
      // show "Serial Number (D)"
      sortSerialNumber.setText("Serial Number (D)");
    }

  }

  @FXML
  void sortValueClicked() {
    // reverse comparator
    valueColumn.setComparator(valueColumn.getComparator().reversed());
    // sort column
    dataTable.getSortOrder().setAll(valueColumn);
    // hide sort triangle
    valueColumn.setSortNode(new Group());

    // if sortValue is showing "Value (D)"
    if (sortValue.getText().equals("Value (D)")) {
      // show "Value (A)"
      sortValue.setText("Value (A)");
      //else
    } else {
      // show "Value (D)"
      sortValue.setText("Value (D)");
    }

  }

}