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

  public void addPersonalInfo(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
  }

  public void addCompanyName(ContactData contactData) {
    type(By.name("company"), contactData.getCompanyName());
  }

  public void addCompanyAddress(ContactData contactData) {
    type(By.name("address"), contactData.getCompanyAddress());
  }

  public void addHomePhone(ContactData contactData) {
    type(By.name("home"), contactData.getHomePhone());
  }

  public void addMobilePhone(ContactData contactData) {
    type(By.name("mobile"), contactData.getMobilePhone());
  }

  public void addWorkPhone(ContactData contactData) {
    type(By.name("work"), contactData.getWorkPhone());
  }

  public void addEmail(ContactData contactData) {
    type(By.name("email"), contactData.getEmail());
  }

  public void addCompanyURL(ContactData contactData) {
    type(By.name("homepage"), contactData.getCompanyURL());
  }

  public void addDay(ContactData contactData) {
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getDay());
  }

  public void addMonth(ContactData contactData) {
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getMonth());
  }

  public void addYear(ContactData contactData) {
    type(By.name("byear"), contactData.getYear());
  }

  public void addNote(ContactData contactData) {
    type(By.name("notes"), contactData.getNote());
  }

  public void addSecondPhone(ContactData contactData) {
    type(By.name("phone2"), contactData.getSecondPhone());
  }

  public void addSecondAddress(ContactData contactData) {
    type(By.name("address2"), contactData.getSecondAddress());
  }


  public void gotoAddContactPage() {
    click(By.linkText("add new"));
  }

  public void modifyContactPage() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitUpdatedContact() {
    click(By.name("update"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAttention() {
    closeAttentionDialog();
  }
}
