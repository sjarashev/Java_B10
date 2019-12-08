package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sun.plugin2.util.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  private NavigationHelper navigationHelper;
  private ContactHelper contactHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private int browser;

  public ApplicationManager(int browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser == BrowserType.MOZILLA) {
      wd = new FirefoxDriver();
    } else if (browser == BrowserType.DEFAULT) {
      wd = new ChromeDriver();
    } else if (browser == BrowserType.INTERNET_EXPLORER) {
      wd = new InternetExplorerDriver();
    }
    //wd.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    wd.manage().window().maximize();
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
