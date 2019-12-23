package ru.stqa.pft.litecart.firstPackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
  public ChromeDriver wd;
  public WebDriverWait wait;

  @BeforeMethod
  public void init() {
    wd = new ChromeDriver();
    wait = new WebDriverWait(wd, 10);
  }

  @AfterMethod
  public void end(){
    wd.quit();
  }
}
