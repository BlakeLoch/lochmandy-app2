/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InventoryManagerTest {

  private String readFile(File file) {
    // read file as a string
    String data = "";
    try {
      data = Files.readString(file.toPath());
    } catch (IOException e) {
      e.printStackTrace();
    }
    // return the string
    return data;
  }

  String testPath = "src" + File.separator + "test" + File.separator + "files";

  @Test
  void add() {
    // inventory = new InventoryManager
    InventoryManager inventory = new InventoryManager();
    // create InventoryItem
    InventoryItem item = new InventoryItem("Name", "A-XXX-XXX-XXX", "$100.00");
    // expected = list of InventoryItems
    List<InventoryItem> expected = new ArrayList<>();
    // add item to list
    expected.add(item);
    // add item to inventory
    inventory.add(item);
    // actual = inventory.getInventory
    List<InventoryItem> actual = inventory.getInventory();
    // assert if actual = expected
    assertEquals(expected, actual);
  }

  @Test
  void remove() {
    // inventory = new InventoryManager
    InventoryManager inventory = new InventoryManager();
    // create InventoryItems
    InventoryItem item1 = new InventoryItem("Name 1", "A-XXX-XXX-XXX", "$100.00");
    InventoryItem item2 = new InventoryItem("Name 2", "B-YYY-YYY-YYY", "$200.00");
    // expected = list of InventoryItems
    List<InventoryItem> expected = new ArrayList<>();
    // add items to expected
    expected.add(item2);
    // add items to inventory
    inventory.add(item1);
    inventory.add(item2);
    // remove item from inventory
    inventory.remove(item1);
    // actual = ToDoList.getInventory
    List<InventoryItem> actual = inventory.getInventory();
    // assert if actual = expected
    assertEquals(expected, actual);
  }

  @Test
  void clear() {
    // inventory = new InventoryManager
    InventoryManager inventory = new InventoryManager();
    // create InventoryItems
    InventoryItem item1 = new InventoryItem("Name 1", "A-XXX-XXX-XXX", "$100.00");
    InventoryItem item2 = new InventoryItem("Name 2", "B-YYY-YYY-YYY", "$200.00");
    // expected = list of InventoryItems
    List<InventoryItem> expected = new ArrayList<>();
    // add items to inventory
    inventory.add(item1);
    inventory.add(item2);
    // clear inventory
    inventory.clear();
    // actual = ToDoList.getInventory
    List<InventoryItem> actual = inventory.getInventory();
    // assert if actual = expected
    assertEquals(expected, actual);
  }

  @Test
  void getInventory() {
    // inventory = new InventoryManager
    InventoryManager inventory = new InventoryManager();
    // create InventoryItems
    InventoryItem item1 = new InventoryItem("Name 1", "A-XXX-XXX-XXX", "$100.00");
    InventoryItem item2 = new InventoryItem("Name 2", "B-YYY-YYY-YYY", "$200.00");
    // expected = list of InventoryItems
    List<InventoryItem> expected = new ArrayList<>();
    // add items to expected
    expected.add(item1);
    expected.add(item2);
    // add items to inventory
    inventory.add(item1);
    inventory.add(item2);
    // actual = ToDoList.getInventory
    List<InventoryItem> actual = inventory.getInventory();
    // assert if actual = expected
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(strings = {"TSV", "HTML", "JSON"})
  void saveInventory(String fileFormat) {
    // inventory = new InventoryManager
    InventoryManager inventory = new InventoryManager();
    // create InventoryItems
    InventoryItem item1 = new InventoryItem("Name 1", "A-XXX-XXX-XXX", "$100.00");
    InventoryItem item2 = new InventoryItem("Name 2", "B-YYY-YYY-YYY", "$200.00");
    InventoryItem item3 = new InventoryItem("Name 3", "C-ZZZ-ZZZ-ZZZ", "$50.00");
    File testFile = new File(testPath + File.separator + "");
    String expected = "";
    if (fileFormat.equals("TSV")) {
      // select test file
      testFile = new File(testPath + File.separator + "saveInventoryTSVTest.txt");
      // expected = string block in the save format
      expected = """
          Serial Number\tName\tValue
          A-XXX-XXX-XXX\tName 1\t$100.00
          B-YYY-YYY-YYY\tName 2\t$200.00
          C-ZZZ-ZZZ-ZZZ\tName 3\t$50.00
          """;
    }
    if (fileFormat.equals("HTML")) {
      // select test file
      testFile = new File(testPath + File.separator + "saveInventoryHTMLTest.html");
      // expected = string block in the save format
      expected = """
          <table>
          	<tr>
          		<th>Serial Number</th>
          		<th>Name</th>
          		<th>Value</th>
          	</tr>
          	<tr>
          		<td>A-XXX-XXX-XXX</td>
          		<td>Name 1</td>
          		<td>$100.00</td>
          	</tr>
          	<tr>
          		<td>B-YYY-YYY-YYY</td>
          		<td>Name 2</td>
          		<td>$200.00</td>
          	</tr>
          	<tr>
          		<td>C-ZZZ-ZZZ-ZZZ</td>
          		<td>Name 3</td>
          		<td>$50.00</td>
          	</tr>
          </table>""";
    }
    if (fileFormat.equals("JSON")) {
      // select test file
      testFile = new File(testPath + File.separator + "saveInventoryJSONTest.json");
      // expected = string block in the save format
      expected = """
          [
            {
              "name": "Name 1",
              "serialNumber": "A-XXX-XXX-XXX",
              "value": "$100.00"
            },
            {
              "name": "Name 2",
              "serialNumber": "B-YYY-YYY-YYY",
              "value": "$200.00"
            },
            {
              "name": "Name 3",
              "serialNumber": "C-ZZZ-ZZZ-ZZZ",
              "value": "$50.00"
            }
          ]""";
    }
    // add items to inventory
    inventory.add(item1);
    inventory.add(item2);
    inventory.add(item3);
    // inventory.saveInventory(testFile, TSV)
    inventory.saveInventory(testFile, fileFormat);
    // actual = read testFile as string
    String actual = readFile(testFile);
    // assert if actual = expected
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @ValueSource(strings = {"TSV", "HTML", "JSON"})
  void loadInventory(String fileFormat) {
    // create InventoryItems
    InventoryItem item1 = new InventoryItem("Name 1", "A-XXX-XXX-XXX", "$100.00");
    InventoryItem item2 = new InventoryItem("Name 2", "B-YYY-YYY-YYY", "$200.00");
    InventoryItem item3 = new InventoryItem("Name 3", "C-ZZZ-ZZZ-ZZZ", "$50.00");
    // select test file
    File testFile = new File(testPath + File.separator + "");
    if (fileFormat.equals("TSV")) {
      testFile = new File(testPath + File.separator + "saveInventoryTSVTest.txt");
    }
    if (fileFormat.equals("HTML")) {
      testFile = new File(testPath + File.separator + "saveInventoryHTMLTest.html");
    }
    if (fileFormat.equals("JSON")) {
      testFile = new File(testPath + File.separator + "saveInventoryJSONTest.json");
    }
    // expected = create InventoryManager object
    InventoryManager expected = new InventoryManager();
    // add InventoryItems to expected
    expected.add(item1);
    expected.add(item2);
    expected.add(item3);
    // actual = create InventoryManager object
    InventoryManager actual = new InventoryManager();
    // actual.loadInventory
    actual.loadInventory(testFile);
    // assert if actual = expected
    assertTrue(actual.equivalentTo(expected));
  }

  @Test
  void equivalentToTrue() {
    // list1 = create InventoryManager object
    InventoryManager inventory1 = new InventoryManager();
    // list2 = create InventoryManager object
    InventoryManager inventory2 = new InventoryManager();
    // create InventoryItems
    InventoryItem item1 = new InventoryItem("Name 1", "A-XXX-XXX-XXX", "$100.00");
    InventoryItem item2 = new InventoryItem("Name 2", "B-YYY-YYY-YYY", "$200.00");
    InventoryItem item3 = new InventoryItem("Name 3", "C-ZZZ-ZZZ-ZZZ", "$50.00");
    InventoryItem item4 = new InventoryItem("Name 4", "D-123-456-789", "$150.00");
    // add items to inventory1
    inventory1.add(item1);
    inventory1.add(item2);
    inventory1.add(item3);
    inventory1.add(item4);
    // add items to inventory2
    inventory2.add(item1);
    inventory2.add(item2);
    inventory2.add(item3);
    inventory2.add(item4);
    // assert true if inventories are equivalent
    assertTrue(inventory1.equivalentTo(inventory2));
  }

  @Test
  void equivalentToFalse() {
    // list1 = create InventoryManager object
    InventoryManager inventory1 = new InventoryManager();
    // list2 = create InventoryManager object
    InventoryManager inventory2 = new InventoryManager();
    // create InventoryItems
    InventoryItem item1 = new InventoryItem("Name 1", "A-XXX-XXX-XXX", "$100.00");
    InventoryItem item2 = new InventoryItem("Name 2", "B-YYY-YYY-YYY", "$200.00");
    InventoryItem item3 = new InventoryItem("Name 3", "C-ZZZ-ZZZ-ZZZ", "$50.00");
    InventoryItem item4 = new InventoryItem("Name 4", "D-123-456-789", "$150.00");
    // add some items to inventory1
    inventory1.add(item1);
    inventory1.add(item3);
    // add different items to inventory2
    inventory1.add(item2);
    inventory2.add(item4);
    // assert false if lists are not equivalent
    assertFalse(inventory1.equivalentTo(inventory2));
  }

}