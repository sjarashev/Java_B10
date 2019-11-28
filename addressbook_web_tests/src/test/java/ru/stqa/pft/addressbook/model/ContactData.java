package ru.stqa.pft.addressbook.model;

public class ContactData {

  private String name;
  private String lastName;
  private String nickName;
  private String title;
  private String companyName;
  private String companyAddress;
  private String companyURL;
  private String email;
  private String workPhone;
  private String mobilePhone;
  private String homePhone;
  private String year;
  private String month;
  private String day;
  private String note;
  private String secondPhone;
  private String secondAddress;

  public ContactData(String name, String lastName, String nickName, String title) {
    this.name = name;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public void setCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress;
  }

  public void setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }

  public void setHomePhone(String homePhone) {
    this.homePhone = homePhone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCompanyURL(String companyURL) {
    this.companyURL = companyURL;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public void setSecondPhone(String secondPhone) {
    this.secondPhone = secondPhone;
  }

  public void setSecondAddress(String secondAddress) {
    this.secondAddress = secondAddress;
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

  public String getTitle() {
    return title;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getCompanyAddress() {
    return companyAddress;
  }

  public String getCompanyURL() {
    return companyURL;
  }

  public String getEmail() {
    return email;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getYear() {
    return year;
  }

  public String getMonth() {
    return month;
  }

  public String getDay() {
    return day;
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




