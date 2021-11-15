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
    this.name = name;
    // set serialNumber to serialNumber
    this.serialNumber = serialNumber;
    // set value to value
    this.value = value;
  }

  public String getName() {
    // return name
    return name;
  }

  public String getSerialNumber() {
    //  return serialNumber
    return serialNumber;
  }

  public String getValue() {
    //  return value
    return value;
  }

  public void setName(String name) {
    // set name to name
    this.name = name;
  }

  public void setSerialNumber(String serialNumber) {
    // set serialNumber to serialNumber
    this.serialNumber = serialNumber;
  }

  public void setValue(String value) {
    // set value to value
    this.value = value;
  }

  public static boolean validateName(String name) {
    // return true if name is 2-256 characters
    return name.length() >= 2 && name.length() <= 256;
  }

  public static boolean validateSerialNumber(String serialNumber) {
    // return true if serialNumber is in the format of A-XXX-XXX-XXX
    return serialNumber.matches("^[a-zA-Z]-[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]-[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]-[a-zA-Z0-9][a-zA-Z0-9][a-zA-Z0-9]$");
  }

  public static boolean validateValue(String value) {
    // return true if value is in the format of money (USD)
    return value.matches("\\$[0-9]*\\.[0-9]{2}");
  }

  public boolean equivalentTo(InventoryItem item) {
    // return true if this.name = item.name and this.serialNumber = item.serialNumber and this.value = item.value
    return name.equals(item.getName()) && serialNumber.equals(item.getSerialNumber()) && value.equals(item.getValue());
  }

}
