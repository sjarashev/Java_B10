package ru.stqa.pft.addressbook.model;

public class PersonalData {
  private final String name;
  private final String lastName;
  private final String nickName;

  public PersonalData(String name, String lastName, String nickName) {
    this.name = name;
    this.lastName = lastName;
    this.nickName = nickName;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }
}
