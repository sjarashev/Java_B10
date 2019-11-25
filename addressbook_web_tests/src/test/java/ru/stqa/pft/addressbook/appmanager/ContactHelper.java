package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitForm() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void additionalInfo(AdditionalData additionalData) {
    type(By.name("address2"), additionalData.getSecondAddress());
    type(By.name("phone2"), additionalData.getSecondPhone());
    type(By.name("notes"), additionalData.getNote());
  }

  public void addBirthDate(DOBdata DOBdata) {
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(DOBdata.getDay());
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(DOBdata.getMonth());
    type(By.name("byear"), DOBdata.getYear());
  }

  public void addContactInfo(ContactData contactData) {
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("homepage"), contactData.getCompanyURL());
  }

  public void addCompanyInfo(CompanyData companyData) {
    type(By.name("company"), companyData.getCompanyName());
    type(By.name("address"), companyData.getCompanyAddress());
  }

  public void addTitle(String title) {
    type(By.name("title"), title);
  }

  public void addPersonalInfo(PersonalData personalData) {
    type(By.name("firstname"), personalData.getName());
    type(By.name("lastname"), personalData.getLastName());
    type(By.name("nickname"), personalData.getNickName());
  }

  public void gotoAddContactPage() {
    click(By.linkText("add new"));
  }
}
