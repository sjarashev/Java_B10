package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.*;

public class ContactHelper extends HelperBase {

  ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitForm() {
    click(By.xpath("(//input[@name='submit'])[2]"));
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

  public void fillContactForm(ContactData contactData){
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompanyName());
    type(By.name("address"), contactData.getCompanyAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("homepage"), contactData.getCompanyURL());
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getDay());
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getMonth());
    type(By.name("byear"), contactData.getYear());
    type(By.name("notes"), contactData.getNote());
    type(By.name("phone2"), contactData.getSecondPhone());
    type(By.name("address2"), contactData.getSecondAddress());
  }
}
