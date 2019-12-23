package ru.stqa.pft.litecart.firstPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TestBase {
  FirefoxDriver wd;

  @BeforeMethod
  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
  }
}
