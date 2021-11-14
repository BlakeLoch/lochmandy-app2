/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryItemTest {

  @BeforeEach
  void setUp() {
    // item = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
  }

  @Test
  void getName() {
    // expected = Name
    // actual = item.getName()
    // assert if expected = actual
  }

  @Test
  void getSerialNumber() {
    // expected = A-XXX-XXX-XXX
    // actual = item.getSerialNumber()
    // assert if expected = actual
  }

  @Test
  void getValue() {
    // expected = $100.00
    // actual = item.getValue()
    // assert if expected = actual
  }

  @Test
  void setName() {
    // expected = New Name
    // actual = item.setName(New Name)
    // assert if expected = actual
  }

  @Test
  void setSerialNumber() {
    // expected = B-YYY-YYY-YYY
    // actual = item.setSerialNumber(B-YYY-YYY-YYY)
    // assert if expected = actual
  }

  @Test
  void setValue() {
    // expected = $200.00
    // actual = item.setValue($200.00)
    // assert if expected = actual
  }

  @Test
  void validateNameTrue() {
    // assert true on InventoryItem.validateName("Name")
  }

  @Test
  void validateNameFalse() {
    // assert false on InventoryItem.validateName("N")
  }

  @Test
  void validateSerialNumberTrue() {
    // assert true on InventoryItem.validateSerialNumber("A-XXX-XXX-XXX")
  }

  @Test
  void validateSerialNumberFalse() {
    // assert false on InventoryItem.validateSerialNumber("A-XXX-XXX")
  }

  @Test
  void validateValueTrue() {
    // assert true on InventoryItem.validateValue("$100.00")
  }

  @Test
  void validateValueFalse() {
    // assert false on InventoryItem.validateValue("100")
  }

  @Test
  void equivalentToTrue() {
    // item 1 = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
    // item 2 = new InventoryItem(Name, A-XXX-XXX-XXX, $100.00)
    // assert true on item1.equivalentTo(item2)
  }

  @Test
  void equivalentToFalse() {
    // item 1 = new InventoryItem(Name 1, A-XXX-XXX-XXX, $100.00)
    // item 2 = new InventoryItem(Name 2, B-YYY-YYY-YYY, $200.00)
    // assert false on item1.equivalentTo(item2)
  }

}