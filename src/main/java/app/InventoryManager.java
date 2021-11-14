/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

  private final List<InventoryItem> inventory = new ArrayList<>();

  public void add(InventoryItem item) {
    // add item to inventory
  }

  public void remove(InventoryItem item) {
    // remove item from inventory
  }

  public void clear() {
    // clear inventory
  }

  public List<InventoryItem> getInventory() {
    // return inventory
    return null;
  }

  public void saveInventory(File outputFile, String fileFormat) {
    // if fileFormat = TSV
    // save inventory as TSV
    // if fileFormat = HTML
    // save inventory as HTML
    // if fileFormat = JSON
    // save inventory as JSON
  }

  private void saveToTSV(File outputFile) {
    // filePath = absolute path of outputFile
    // if filePath does not end with .txt
    // outputFile = filePath + .txt
    // write "Serial Number\tName\t"Value"
    // create fileWriter in try with resources
    // for each item
    // write serialNumber + "\t" + name + "\t" + value+\n
    // catch error
  }

  private void saveToHTML(File outputFile) {
    // filePath = absolute path of outputFile
    // if filePath does not end with .html
    // outputFile = filePath + .html

    // create fileWriter in try with resources
    // write "<table>\n\t<tr>\n\t\t<th>Serial Number</th>\n\t\t<th>Name</th>\n\t\t<th>Value</th>\n\t</tr>"
    // for each item
    // write "\t<tr>\n\t\t<th>"+serialNumber+"</th>\n\t\t<th>"+name+"</th>\n\t\t<th>"+value+"</th>\n\t</tr>"
    // write "</table>"
    // catch error
  }

  private void saveToJSON(File outputFile) {
    // filePath = absolute path of outputFile
    // if filePath does not end with .json
    // outputFile = filePath + .json

    // create fileWriter in try with resources
    // create new gson object
    // jsonOutput = inventory to json
    // write jsonOutput
    // catch error
  }

  public void loadInventory(File inputFile) {
    // if inputFile ends in .tsv
    // load inventory from TSV
    // if inputFile ends in .html
    // load inventory from HTML
    // if inputFile ends in .json
    // load inventory from JSON
  }

  private void loadFromTSV(File inputFile) {
    // create scanner for inputFile in try with resources
    // ignore the header line
    // while there is a next line
    // tokenize the input line on \t
    // create an item with token1 = serialNumber, token2 = name, token3 = value
    // add item to inventory
    // catch error
  }

  private void loadFromHTML(File inputFile) {
    // create scanner for inputFile in try with resources
    // ignore the first 6 lines
    // while line does not start with "</table>"
    // scan 5 lines into string
    // trim "<tr>" from the front
    // trim "</tr>" from the back
    // replace "<td>" and "</td>" with "\t"
    // tokenize the input line on \t
    // create an item with token1 = serialNumber, token2 = name, token3 = value
    // add item to inventory
    // catch error
  }

  private void loadFromJSON(File inputFile) {
    // create scanner for inputFile in try with resources
    // read inputFile as string into inputFileString
    // inventory = inputFileString from json
    // catch error
  }

  public boolean equivalentTo(InventoryManager inventory) {
    // set returnValue to true
    // iterate through items in inventory
    // get index of item
    // if items are not equivalent at index
    // set returnValue to false
    // return returnValue
    return false;
  }

}
