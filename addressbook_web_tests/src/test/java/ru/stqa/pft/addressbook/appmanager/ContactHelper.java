package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;
import java.util.ArrayList;
import java.util.List;

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

  public void modifyContactPage(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitUpdatedContact() {
    click(By.name("update"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeAttention() {
    closeAttentionDialog();
  }

  private void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    if (creation) {
      try {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } catch (Exception e) {
        createGroup();
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
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

  private void createGroup(){
    NavigationHelper n = new NavigationHelper(wd);
    GroupHelper g = new GroupHelper(wd);
    n.groupPage();
    GroupData group = new GroupData().withName("group").withHeader("header").withFooter("footer");
    g.initGroupPage();
    g.fillGroupForm(group);
    g.submitGroupCreation();
    gotoAddContactPage();
  }

  public void modify(ContactData conData, int index) {
    modifyContactPage(index);
    fillContactForm(conData, false);
    submitUpdatedContact();
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
    closeAttention();
  }

  private void fillPartialContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
  }

  public boolean thereIsNoContact() {
    return !isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    gotoAddContactPage();
    fillPartialContactForm(contact);
    submitForm();
    returnToHomePage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String name = element.findElement(By.xpath("./td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, name, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
