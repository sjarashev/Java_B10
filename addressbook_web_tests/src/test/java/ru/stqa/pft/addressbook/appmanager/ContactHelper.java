package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void modifyContactPageById(int id) {
    List<WebElement> rows = wd.findElements(By.xpath("//tr[@class]"));
    int number = wd.findElements(By.xpath("//tr[@class]")).size();
    for (int i=0;i<number;i++){
      WebElement w = rows.get(i);
      if (w.findElements(By.xpath(".//input[@id='" + id + "']")).size()!=0) {
        w.findElement(By.xpath(".//img[@alt='Edit']")).click();
        break;
      }
    }
  }

  public void modify(ContactData conData) {
    modifyContactPageById(conData.getId());
    fillContactForm(conData, false);
    submitUpdatedContact();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    closeAttention();
    goToHomePage();
  }

  public void submitUpdatedContact() {
    click(By.name("update"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void goToHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
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

  public void createNew(ContactData conData) {
    gotoAddContactPage();
    fillContactForm(conData, true);
    submitForm();
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

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element:elements){
      String name = element.findElement(By.xpath("./td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      contacts.add(new ContactData().withId(id).withName(name));
    }
    return contacts;
  }
}
