package ru.stqa.pft.addressbook.model;

public class AdditionalData {
  private final String note;
  private final String secondPhone;
  private final String secondAddress;

  public AdditionalData(String note, String secondPhone, String secondAddress) {
    this.note = note;
    this.secondPhone = secondPhone;
    this.secondAddress = secondAddress;
  }

  public String getNote() {
    return note;
  }

  public String getSecondPhone() {
    return secondPhone;
  }

  public String getSecondAddress() {
    return secondAddress;
  }
}
