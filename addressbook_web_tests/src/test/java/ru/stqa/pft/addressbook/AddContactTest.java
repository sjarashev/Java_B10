package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.*;

public class AddContactTest {
  private WebDriver driver;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\sjarashev\\Desktop\\Java Training\\Java_B10\\FirstProject\\webdriver\\geckodriver0.24_win64.exe");
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddContact() throws Exception {
    driver.get("http://localhost/addressbook/");
    login("admin", "secret");
    gotoAddContactPage();
    addPersonalInfo(new PersonalData("David", "John", "DJ"));
    addTitle("CEO");
    addCompanyInfo(new CompanyData("ABC", "555 first line"));
    addContactInfo(new ContactData("www.abc.com", "dj@gmail.com", "777777", "mobilePhone", "555555"));
    addBirthDate(new DOBdata("1979", "December", "10"));
    additionalInfo(new AdditionalData("bla", "secondPhone", "second line"));
    submitForm();
    gotoHomePage();
    logout();
  }

  private void logout() {
    driver.findElement(By.linkText("Logout")).click();
  }

  private void gotoHomePage() {
    driver.findElement(By.linkText("home page")).click();
  }

  private void submitForm() {
    driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void additionalInfo(AdditionalData additionalData) {
    driver.findElement(By.name("address2")).sendKeys(additionalData.getSecondAddress());
    driver.findElement(By.name("phone2")).sendKeys(additionalData.getSecondPhone());
    driver.findElement(By.name("notes")).sendKeys(additionalData.getNote());
  }

  private void addBirthDate(DOBdata DOBdata) {
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(DOBdata.getDay());
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(DOBdata.getMonth());
    driver.findElement(By.name("byear")).sendKeys(DOBdata.getYear());
  }

  private void addContactInfo(ContactData contactData) {
    driver.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
    driver.findElement(By.name("mobile")).sendKeys(contactData.getMobilePhone());
    driver.findElement(By.name("work")).sendKeys(contactData.getWorkPhone());
    driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    driver.findElement(By.name("homepage")).sendKeys(contactData.getCompanyURL());
  }

  private void addCompanyInfo(CompanyData companyData) {
    driver.findElement(By.name("company")).sendKeys(companyData.getCompanyName());
    driver.findElement(By.name("address")).sendKeys(companyData.getCompanyAddress());
  }

  private void addTitle(String title) {
    driver.findElement(By.name("title")).sendKeys(title);
  }

  private void addPersonalInfo(PersonalData personalData) {
    driver.findElement(By.name("firstname")).sendKeys(personalData.getName());
    driver.findElement(By.name("lastname")).sendKeys(personalData.getLastName());
    driver.findElement(By.name("nickname")).sendKeys(personalData.getNickName());
  }

  private void gotoAddContactPage() {
    driver.findElement(By.linkText("add new")).click();
  }

  private void login(String username, String password) {
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
