package ru.stqa.pft.litecart.appmanager;

public class PersonalData {

  private String firstName;
  private String lastName;
  private String taxId;
  private String companyName;
  private String homeAddress;
  private String postalCode;
  private String city;
  private String email;
  private String phone;
  private String password;
  private String confirmPassword;

  public PersonalData(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void setTaxId(String taxId) {
    this.taxId = taxId;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }


  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTaxId() {
    return taxId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getHomeAddress() {
    return homeAddress;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public String getCity() {
    return city;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getPassword() {
    return password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }
}




