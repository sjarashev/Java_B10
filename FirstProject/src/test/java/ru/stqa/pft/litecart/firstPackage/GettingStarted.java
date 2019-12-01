package ru.stqa.pft.litecart.firstPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GettingStarted {

/*  @Test
   public void loopThroughMenuItems() throws InterruptedException {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\sjarashev\\Desktop\\Java Training\\Java_B10\\FirstProject\\webdriver\\geckodriver0.24_win64.exe");
    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
    driver.get("http://localhost/litecart/admin");
    driver.manage().window().maximize();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();

    List<WebElement> id = driver.findElements(By.xpath("//li[@id='app-']"));

    for (int i = 1; i <= id.size(); i++) {
      driver.findElement(By.xpath("//li[@id='app-'][" + i + "]")).click();
      List<WebElement> con = driver.findElements(By.xpath("//ul[@class='docs']"));
      if (con != null) {
        List<WebElement> attr = driver.findElements(By.xpath("//li[@id='app-']/ul[@class='docs']/li[contains(@id,'doc')]"));
        for (int j = 1; j <= attr.size(); j++) {
          driver.findElement(By.xpath("//tr//li[@id='app-']/ul[@class='docs']/li[contains(@id,'doc')][" + j + "]")).click();
          boolean present;
          try {
            driver.findElement(By.xpath("//tr/td/h1"));
            present = true;
          } catch (NoSuchElementException e) {
            present = false;
          }
          System.out.println(present);
        }
      }
    }
    driver.quit();
  }*/


  @Test
  public void checkStickers() throws InterruptedException {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\sjarashev\\Desktop\\Java Training\\Java_B10\\FirstProject\\webdriver\\geckodriver0.24_win64.exe");
    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
    driver.get("http://localhost/litecart/en/");
    driver.manage().window().maximize();

    List<WebElement> duck = driver.findElements(By.xpath("//li[contains(@class, 'product')]"));
    List<WebElement> sticker = driver.findElements(By.xpath("//div[contains(@class, 'sticker')]"));

    int d = duck.size();
    int s = sticker.size();
    Assert.assertEquals(d, s);

    for (int i = 1; i <= duck.size(); i++) {
      driver.findElements(By.xpath("//li[contains(@class, 'product')][" + i + "]"));
      boolean present;
      try {
        driver.findElement(By.xpath("//div[contains(@class, 'sticker')]"));
        present = true;
      } catch (NoSuchElementException e) {
        present = false;
      }
      Assert.assertTrue(present);
    }
    driver.quit();
  }
}



