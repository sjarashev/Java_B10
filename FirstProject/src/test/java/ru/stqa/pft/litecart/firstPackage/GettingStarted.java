package ru.stqa.pft.litecart.firstPackage;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GettingStarted extends TestBase {

  /*@Test
  public void loopThroughMenuItems() {
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();

    List<WebElement> id = wd.findElements(By.xpath("//li[@id='app-']"));

    for (int i = 1; i <= id.size(); i++) {
      wd.findElement(By.xpath("//li[@id='app-'][" + i + "]")).click();
      List<WebElement> con = wd.findElements(By.xpath("//ul[@class='docs']"));
      if (con != null) {
        List<WebElement> attr = wd.findElements(By.xpath("//li[contains(@id,'doc')]"));
        for (int j = 1; j <= attr.size(); j++) {
          wd.findElement(By.xpath("//li[contains(@id,'doc')][" + j + "]")).click();
          boolean present;
          try {
            wd.findElement(By.xpath("//tr/td/h1"));
            present = true;
          } catch (NoSuchElementException e) {
            present = false;
          }
          Assert.assertTrue(present);
        }
      }
    }
    wd.quit();
  }*/

  /*@Test
  public void checkStickers() {

    List<WebElement> ducks = wd.findElements(By.xpath("//li[contains(@class, 'product')]"));

    for (WebElement duck : ducks) {
      int sticker = duck.findElements(By.xpath(".//div[contains(@class, 'sticker')]")).size();
      if (sticker > 0) {
        assertEquals(sticker, 1);
        System.out.println(sticker);
      }
    }
    wd.quit();
  }*/

  @Test (enabled = false)
  public void checkAlphaOrder() throws InterruptedException {
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();

    TestHelper testHelper = new TestHelper();

    List<WebElement> countries = wd.findElements(By.xpath("//tr//td[5]/a"));
    List<String> listOfCountries = testHelper.createListOf(countries);
    testHelper.sort(listOfCountries);
    int numberOfCountries = wd.findElements(By.xpath("//tr[@class='row']")).size();

    for (int i = 0; i < numberOfCountries; i++) {
      List<WebElement> we = wd.findElements(By.xpath("//tr[@class='row']"));
      WebElement w = we.get(i);
      if (Integer.parseInt(w.findElement(By.xpath("./td[6]")).getText().trim())>0){
        w.findElement(By.xpath("./td[5]/a[@href]")).click();
        List<WebElement> zones = wd.findElements(By.xpath("//table[@class='dataTable']//tr/td[3]"));
        List<String> listOfZones = testHelper.createListOf(zones);
        testHelper.sort(listOfZones);
        wd.findElement(By.xpath("//li[3]//a[1]")).click();
      }
    }
    wd.quit();
  }

  @Test(enabled = true)
  public void checkAlphaOrder2() throws InterruptedException {
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();

    TestHelper testHelper = new TestHelper();

    int numberOfCountries = wd.findElements(By.xpath("//tr[@class='row']")).size();

    for (int i = 0; i < numberOfCountries; i++) {
      List<WebElement> we = wd.findElements(By.xpath("//tr[@class='row']"));
      WebElement w = we.get(i);
      w.findElement(By.xpath("./td[3]/a[@href]")).click();
      List<WebElement> zones = wd.findElements(By.xpath("//form//td[3]//option[@selected='selected']"));
      List<String> listOfZones = testHelper.createListOf(zones);
      testHelper.sort(listOfZones);
      wd.findElement(By.xpath("//li[6]//a[1]")).click();
    }
    wd.quit();
  }
}