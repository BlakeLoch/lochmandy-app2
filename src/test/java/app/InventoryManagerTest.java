/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryManagerTest {

  @BeforeEach
  void setUp() {
    // inventory = new InventoryManager
  }

  @Test
  void add() {
    // create InventoryItem
    // expected = list of InventoryItems
    // add item to list
    // add item to inventory
    // actual = ToDoList.getInventory
    // assert if actual = expected
  }

  @Test
  void remove() {
    // create InventoryItems
    // expected = list of InventoryItems
    // add items to list
    // remove item from list
    // add items to inventory
    // remove item from inventory
    // actual = ToDoList.getInventory
    // assert if actual = expected
  }

  @Test
  void clear() {
    // create InventoryItems
    // expected = list of InventoryItems
    // add items to inventory
    // clear inventory
    // actual = ToDoList.getInventory
    // assert if actual = expected
  }

  @Test
  void getInventory() {
    // create InventoryItems
    // expected = list of InventoryItems
    // add items to list
    // add items to inventory
    // actual = ToDoList.getInventory
    // assert if actual = expected
  }

  @Test
  void saveInventoryTSV() {
    // create InventoryItems
    // select test file
    // expected = string block in the save format
    // add items to inventory
    // actual = read saveTest as string
    // inventory.saveInventory(testFile, TSV)
    // assert if actual = expected
  }

  @Test
  void saveInventoryHTML() {
    // create InventoryItems
    // select test file
    // expected = string block in the save format
    // add items to inventory
    // actual = read saveTest as string
    // inventory.saveInventory(testFile, HTML)
    // assert if actual = expected
  }

  @Test
  void saveInventoryJSON() {
    // create InventoryItems
    // select test file
    // expected = string block in the save format
    // add items to inventory
    // actual = read saveTest as string
    // inventory.saveInventory(testFile, JSON)
    // assert if actual = expected
  }

  @Test
  void loadInventoryTSV() {
    // create InventoryItems
    // select test file
    // expected = create InventoryManager object
    // add InventoryItems to expected
    // actual = create InventoryManager object
    // actual.loadInventory
    // assert if actual = expected
  }

  @Test
  void loadInventoryHTML() {
    // create InventoryItems
    // select test file
    // expected = create InventoryManager object
    // add InventoryItems to expected
    // actual = create InventoryManager object
    // actual.loadInventory
    // assert if actual = expected
  }

  @Test
  void loadInventoryJSON() {
    // create InventoryItems
    // select test file
    // expected = create InventoryManager object
    // add InventoryItems to expected
    // actual = create InventoryManager object
    // actual.loadInventory
    // assert if actual = expected
  }

  @Test
  void equivalentToTrue() {
    // list1 = create InventoryManager object
    // list2 = create InventoryManager object
    // create InventoryItems
    // add items to list1
    // add items to list2
    // assert true if lists are equivalent
  }

  @Test
  void equivalentToFalse() {
    // list1 = create InventoryManager object
    // list2 = create InventoryManager object
    // create InventoryItems
    // add some items to list1
    // add different items to list2
    // assert false if lists are not equivalent
  }
  
}