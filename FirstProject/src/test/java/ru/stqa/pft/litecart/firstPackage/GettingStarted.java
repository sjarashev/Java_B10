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

  @Test
  public void checkAlphaOrder() throws InterruptedException {
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();

    TestHelper testHelper = new TestHelper();

    List<WebElement> countries = wd.findElements(By.xpath("//tr//td[5]/a"));
    List<WebElement> filteredCountries = testHelper.filter(wd.findElements(By.xpath("//tr[@class='row']")));
    List<String> listOfCountries = testHelper.createListOf(countries);

    testHelper.sort(listOfCountries);

    for (WebElement f : filteredCountries) {
      f.findElement(By.xpath(".//td[5]/a[@href]")).click();
      List<WebElement> zones = wd.findElements(By.xpath("//table[@class='dataTable']//tr/td[3]"));
      List<String> listOfZones = testHelper.createListOf(zones);
      testHelper.sort(listOfZones);
      wd.findElement(By.xpath("//li[3]//a[1]")).click();
      //wd.navigate().refresh();
    }
    wd.quit();
  }


}