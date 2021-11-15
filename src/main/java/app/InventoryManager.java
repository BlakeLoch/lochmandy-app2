/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {

  private final List<InventoryItem> inventory = new ArrayList<>();
  private static final String DOTTXT = ".txt";
  private static final String DOTHTML = ".html";
  private static final String DOTJSON = ".json";

  public void add(InventoryItem item) {
    // add item to inventory
    inventory.add(item);
  }

  public void remove(InventoryItem item) {
    // remove item from inventory
    inventory.remove(item);
  }

  public void clear() {
    // clear inventory
    inventory.clear();
  }

  public List<InventoryItem> getInventory() {
    // return inventory
    return inventory;
  }

  public void saveInventory(File outputFile, String fileFormat) {
    // if fileFormat = TSV
    if (fileFormat.equals("TSV")) {
      // save inventory as TSV
    saveToTSV(outputFile);
    }
    // if fileFormat = HTML
    if (fileFormat.equals("HTML")) {
      // save inventory as HTML
      saveToHTML(outputFile);
    }
    // if fileFormat = JSON
    if (fileFormat.equals("JSON")) {
      // save inventory as JSON
      saveToJSON(outputFile);
    }
  }

  private void saveToTSV(File outputFile) {
    // filePath = absolute path of outputFile
    String filePath = outputFile.getAbsolutePath();
    // if filePath does not end with .txt
    if (!filePath.endsWith(DOTTXT)) {
    // outputFile = filePath + .txt
      outputFile = new File(filePath + DOTTXT);
    }
    // create fileWriter in try with resources
    try (FileWriter output = new FileWriter(outputFile)) {
      // write "Serial Number\tName\tValue\n"
      output.write("Serial Number\tName\tValue\n");
      // for each item
      for (InventoryItem item : inventory) {
        // write serialNumber + "\t" + name + "\t" + value+\n
        output.write(item.getSerialNumber() + "\t" + item.getName() + "\t" + item.getValue() + "\n");
      }
    }
    // catch error
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void saveToHTML(File outputFile) {
    // filePath = absolute path of outputFile
    String filePath = outputFile.getAbsolutePath();
    // if filePath does not end with .html
    if (!filePath.endsWith(DOTHTML)) {
    // outputFile = filePath + .html
      outputFile = new File(filePath + DOTHTML);
    }
    // create fileWriter in try with resources
    try (FileWriter output = new FileWriter(outputFile)) {
    // write "<table>\n\t<tr>\n\t\t<th>Serial Number</th>\n\t\t<th>Name</th>\n\t\t<th>Value</th>\n\t</tr>\n"
      output.write( "<table>\n\t<tr>\n\t\t<th>Serial Number</th>\n\t\t<th>Name</th>\n\t\t<th>Value</th>\n\t</tr>\n");
    // for each item
      for (InventoryItem item : inventory) {
    // write "\t<tr>\n\t\t<th>"+serialNumber+"</th>\n\t\t<th>"+name+"</th>\n\t\t<th>"+value+"</th>\n\t</tr>\n"
        output.write("\t<tr>\n\t\t<td>"+item.getSerialNumber()+"</td>\n\t\t<td>"+item.getName()+"</td>\n\t\t<td>"+item.getValue()+"</td>\n\t</tr>\n");
        }
    // write "</table>"
      output.write("</table>");
      }
    // catch error
       catch (IOException e) {
        e.printStackTrace();
      }
  }

  private void saveToJSON(File outputFile) {
    // filePath = absolute path of outputFile
    String filePath = outputFile.getAbsolutePath();
    // if filePath does not end with .json
    if (!filePath.endsWith(DOTJSON)) {
    // outputFile = filePath + .json
      outputFile = new File(filePath + DOTJSON);
    }
    // create fileWriter in try with resources
    try (FileWriter output = new FileWriter(outputFile)) {
      // create new gson object
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      // write inventory as Json to output
      gson.toJson(inventory, output);
    }
    // catch error
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void loadInventory(File inputFile) {
    // filePath = absolute path of outputFile
    String filePath = inputFile.getAbsolutePath();
    // if filePath ends in .txt
    if (filePath.endsWith(DOTTXT)) {
      // load inventory from TSV
      loadFromTSV(inputFile);
    }
    // if filePath ends in .html
    if (filePath.endsWith(DOTHTML)) {
      // load inventory from HTML
      loadFromHTML(inputFile);
    }
    // if filePath ends in .json
    if (filePath.endsWith(DOTJSON)) {
      // load inventory from JSON
      loadFromJSON(inputFile);
    }
  }

  private void loadFromTSV(File inputFile) {
    // create scanner for inputFile in try with resources
    try (Scanner input = new Scanner(inputFile)) {
      // ignore the header line
      input.nextLine();
      // while there is a next line
      while (input.hasNextLine()) {
        // tokenize the input line on \t
        String[] itemTokens = input.nextLine().split("\t");
        // create an item with token0 = serialNumber, token1 = name, token2 = value
        InventoryItem item = new InventoryItem(itemTokens[1], itemTokens[0], itemTokens[2]);
        // add item to inventory
        inventory.add(item);
      }
    }
    // catch error
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void loadFromHTML(File inputFile) {
    // create scanner for inputFile in try with resources
    try (Scanner input = new Scanner(inputFile)) {
      // ignore the first 6 lines
      for (int i = 0; i < 6; i++) {
        input.nextLine();
      }
      // while line does not start with "</table>"
      String line = input.nextLine();
      while (!line.equals("</table>")) {
        StringBuilder itemStringBuilder;
        itemStringBuilder = new StringBuilder(line);
        for (int i = 0; i < 4; i++) {
          // scan 5 lines into string
          itemStringBuilder.append(input.nextLine());
        }
        String itemString = itemStringBuilder.toString();
        // replace "\t" with ""
        itemString = itemString.replace("\t", "");
        // replace "<tr>" with ""
        itemString = itemString.replace("<tr>", "");
        // replace "</tr>" with ""
        itemString = itemString.replace("<\tr>", "");
        // replace "<td>" and "</td>" with "\t"
        itemString = itemString.replace("<td>", "");
        itemString = itemString.replace("</td>", "\t");
        // tokenize the input line on \t
        String[] itemTokens = itemString.split("\t");
        // create an item with token0 = serialNumber, token1 = name, token2 = value
        InventoryItem item = new InventoryItem(itemTokens[1], itemTokens[0], itemTokens[2]);
        // add item to inventory
        inventory.add(item);
        line = input.nextLine();
      }
    }
    // catch error
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void loadFromJSON(File inputFile) {
    // create scanner for inputFile in try with resources
    try {
      // read inputFile as string into inputFileString
      String data = Files.readString(inputFile.toPath());
      // create new gson object
      Gson gson = new Gson();
      // inventory = inputFileString from json
      inventory.addAll(gson.fromJson(data, new TypeToken<List<InventoryItem>>(){}.getType()));
    }
    // catch error
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean equivalentTo(InventoryManager inventory) {
    // set returnValue to true
    boolean returnValue = true;
    // iterate through items in inventory
    for (InventoryItem item : inventory.getInventory()) {
      // get index of item
      int index = inventory.getInventory().indexOf(item);
      // if items are not equivalent at index
      if (!item.equivalentTo(this.inventory.get(index))) {
        // set returnValue to false
        returnValue = false;
      }
    }
    // return returnValue
    return returnValue;
  }

}
