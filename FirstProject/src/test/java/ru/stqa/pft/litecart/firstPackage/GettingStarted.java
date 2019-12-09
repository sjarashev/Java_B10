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

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GettingStarted extends TestBase{

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
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\sjarashev\\Desktop\\Java Training\\Java_B10\\FirstProject\\webdriver\\geckodriver0.24_win64.exe");
    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
    driver.get("http://localhost/litecart/en/");
    driver.manage().window().maximize();

    List<WebElement> ducks = driver.findElements(By.xpath("//li[contains(@class, 'product')]"));

    for (WebElement duck : ducks) {
      int sticker = duck.findElements(By.xpath(".//div[contains(@class, 'sticker')]")).size();
      if (sticker > 0) {
        assertEquals(sticker, 1);
        System.out.println(sticker);
      }
    }
    driver.quit();
  }*/

  @Test
  public void checkAlphaOrder() throws InterruptedException {
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();

    TestHelper testHelper = new TestHelper();

    List<WebElement> countries = wd.findElements(By.xpath("//tr//td[5]/a"));
    List<WebElement> lines = wd.findElements(By.xpath("//tr[@class='row']"));

    List<String> listOfCountries = testHelper.createListOf(countries);

    testHelper.sort(listOfCountries);

    for (WebElement line:lines){

      int i = Integer.parseInt(wd.findElement(By.xpath("//tr[@class='row']/td[6]")).getText().trim());
      if (i > 0){

        line.findElement(By.xpath(".//td[5]/a[@href]")).click();
        //TimeUnit.SECONDS.sleep(1);
        List<WebElement> zones = wd.findElements(By.xpath("//table[@class='dataTable']//tr/td[3]"));
        List<String> listOfZones = testHelper.createListOf(zones);
        testHelper.sort(listOfZones);
        wd.findElement(By.xpath("//li[3]//a[1]")).click();
        TimeUnit.SECONDS.sleep(3);
      }
    }
    wd.quit();
  }
}

