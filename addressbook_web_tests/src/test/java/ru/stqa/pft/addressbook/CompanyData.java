package ru.stqa.pft.addressbook;

public class CompanyData {
  private final String companyName;
  private final String companyAddress;

  public CompanyData(String companyName, String companyAddress) {
    this.companyName = companyName;
    this.companyAddress = companyAddress;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getCompanyAddress() {
    return companyAddress;
  }
}
