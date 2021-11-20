/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class InventoryItemTest {

  @Test
  void getName() {
    // item = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
    InventoryItem item = new InventoryItem("Name", "A-XXX-XXX-XXX", "$100.00");
    // expected = Name
    String expected = "Name";
    // actual = item.getName()
    String actual = item.getName();
    // assert if expected = actual
    assertEquals(expected, actual);
  }

  @Test
  void getSerialNumber() {
    // item = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
    InventoryItem item = new InventoryItem("Name", "A-XXX-XXX-XXX", "$100.00");
    // expected = A-XXX-XXX-XXX
    String expected = "A-XXX-XXX-XXX";
    // actual = item.getSerialNumber()
    String actual = item.getSerialNumber();
    // assert if expected = actual
    assertEquals(expected, actual);
  }

  @Test
  void getValue() {
    // item = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
    InventoryItem item = new InventoryItem("Name", "A-XXX-XXX-XXX", "$100.00");
    // expected = $100.00
    String expected = "$100.00";
    // actual = item.getValue()
    String actual = item.getValue();
    // assert if expected = actual
    assertEquals(expected, actual);
  }

  @Test
  void setName() {
    // item = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
    InventoryItem item = new InventoryItem("Name", "A-XXX-XXX-XXX", "$100.00");
    // expected = New Name
    String expected = "New Name";
    // actual = item.setName(New Name)
    item.setName("New Name");
    String actual = item.getName();
    // assert if expected = actual
    assertEquals(expected, actual);

  }

  @Test
  void setSerialNumber() {
    // item = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
    InventoryItem item = new InventoryItem("Name", "A-XXX-XXX-XXX", "$100.00");
    // expected = B-YYY-YYY-YYY
    String expected = "B-YYY-YYY-YYY";
    // actual = item.setSerialNumber(B-YYY-YYY-YYY)
    item.setSerialNumber("B-YYY-YYY-YYY");
    String actual = item.getSerialNumber();
    // assert if expected = actual
    assertEquals(expected, actual);
  }

  @Test
  void setValue() {
    // item = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
    InventoryItem item = new InventoryItem("Name", "A-XXX-XXX-XXX", "$100.00");
    // expected = $200.00
    String expected = "$200.00";
    // actual = item.setValue($200.00)
    item.setValue("$200.00");
    String actual = item.getValue();
    // assert if expected = actual
    assertEquals(expected, actual);
  }

  @Test
  void validateNameTrue() {
    // assert true on InventoryItem.validateName("Name")
    assertTrue(InventoryItem.validateName("Name"));
  }

  @Test
  void validateNameFalse() {
    // assert false on InventoryItem.validateName("N")
    assertFalse(InventoryItem.validateName("N"));
  }

  @Test
  void validateSerialNumberTrue() {
    // assert true on InventoryItem.validateSerialNumber("A-XXX-XXX-XXX")
    assertTrue(InventoryItem.validateSerialNumber("A-XXX-XXX-XXX"));
  }

  @Test
  void validateSerialNumberFalse() {
    // assert false on InventoryItem.validateSerialNumber("A-XXX-XXX")
    assertFalse(InventoryItem.validateSerialNumber("A-XXX-XXX"));
  }

  @Test
  void validateValueTrue() {
    // assert true on InventoryItem.validateValue("$100.00")
    assertTrue(InventoryItem.validateValue("$100.00"));
  }

  @Test
  void validateValueFalse() {
    // assert false on InventoryItem.validateValue("100")
    assertFalse(InventoryItem.validateValue("100"));
  }

  @Test
  void equivalentToTrue() {
    // item 1 = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
    InventoryItem item1 = new InventoryItem("Name", "A-XXX-XXX-XXX", "$100.00");
    // item 2 = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
    InventoryItem item2 = new InventoryItem("Name", "A-XXX-XXX-XXX", "$100.00");
    // assert true on item1.equivalentTo(item2)
    assertTrue(item1.equivalentTo(item2));
  }

  @Test
  void equivalentToFalse() {
    // item 1 = new InventoryItem(Name 1, A-XXX-XXX-XXX, $100.00)
    InventoryItem item1 = new InventoryItem("Name 1", "A-XXX-XXX-XXX", "$100.00");
    // item 2 = new InventoryItem(Name 2, B-YYY-YYY-YYY, $200.00)
    InventoryItem item2 = new InventoryItem("Name 2", "B-YYY-YYY-YYY", "$200.00");
    // assert false on item1.equivalentTo(item2)
    assertFalse(item1.equivalentTo(item2));
  }

}