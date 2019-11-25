package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.*;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private WebDriver wd;

  public void init() {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\sjarashev\\Desktop\\Java Training\\Java_B10\\FirstProject\\webdriver\\geckodriver0.24_win64.exe");
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin","secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);

    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupPage() {
    wd.findElement(By.name("new")).click();
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void gotoHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  public void submitForm() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void additionalInfo(AdditionalData additionalData) {
    wd.findElement(By.name("address2")).sendKeys(additionalData.getSecondAddress());
    wd.findElement(By.name("phone2")).sendKeys(additionalData.getSecondPhone());
    wd.findElement(By.name("notes")).sendKeys(additionalData.getNote());
  }

  public void addBirthDate(DOBdata DOBdata) {
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(DOBdata.getDay());
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(DOBdata.getMonth());
    wd.findElement(By.name("byear")).sendKeys(DOBdata.getYear());
  }

  public void addContactInfo(ContactData contactData) {
    wd.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
    wd.findElement(By.name("work")).sendKeys(contactData.getWorkPhone());
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    wd.findElement(By.name("homepage")).sendKeys(contactData.getCompanyURL());
  }

  public void addCompanyInfo(CompanyData companyData) {
    wd.findElement(By.name("company")).sendKeys(companyData.getCompanyName());
    wd.findElement(By.name("address")).sendKeys(companyData.getCompanyAddress());
  }

  public void addTitle(String title) {
    wd.findElement(By.name("title")).sendKeys(title);
  }

  public void addPersonalInfo(PersonalData personalData) {
    wd.findElement(By.name("firstname")).sendKeys(personalData.getName());
    wd.findElement(By.name("lastname")).sendKeys(personalData.getLastName());
    wd.findElement(By.name("nickname")).sendKeys(personalData.getNickName());
  }

  public void gotoAddContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void stop() {
    wd.quit();
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
