package ru.stqa.pft.addressbook;

public class ContactData {
  private final String companyURL;
  private final String email;
  private final String workPhone;
  private final String mobilePhone;
  private final String homePhone;

  public ContactData(String companyURL, String email, String workPhone, String mobilePhone, String homePhone) {
    this.companyURL = companyURL;
    this.email = email;
    this.workPhone = workPhone;
    this.mobilePhone = mobilePhone;
    this.homePhone = homePhone;
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
}
