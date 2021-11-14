/*
 * UCF COP3330 Fall 2021 Application Assignment 2 Solution
 * Copyright 2021 Blake Lochmandy
 */

package app;

public class InventoryItem {

  private String name;
  private String serialNumber;
  private String value;



  public InventoryItem(String name, String serialNumber, String value) {
    // set name to name
    // set serialNumber to serialNumber
    // set value to value
  }

  public String getName() {
    // return name
    return "";
  }

  public String getSerialNumber() {
    //  return serialNumber
    return "";
  }

  public String getValue() {
    //  return value
    return "";
  }

  public void setName(String name) {
    // set name to name
  }

  public void setSerialNumber(String serialNumber) {
    // set serialNumber to serialNumber
  }

  public void setValue(String value) {
    // set value to value
  }

  public static boolean validateName(String name) {
    // return true if name is 2-256 characters
    return false;
  }

  public static boolean validateSerialNumber(String serialNumber) {
    // return true if serialNumber is in the format of A-XXX-XXX-XXX
    return false;
  }

  public static boolean validateValue(String value) {
    // return true if value is in the format of money (USD)
    return false;
  }

  public boolean equivalentTo(InventoryItem item) {
    // return true if this.name = item.name and this.serialNumber = item.serialNumber and this.value = item.value
    return false;
  }

}
