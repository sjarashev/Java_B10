package ru.stqa.pft.litecart.firstPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

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

  @Test(enabled = false)
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

  @Test(enabled = true)
  public void checkCampaignsItem() throws InterruptedException {

    WebElement campaignName = wd.findElement(By.xpath("//div[@id='box-campaigns']//a/div[2]"));
    WebElement campaignRegularPrice = wd.findElement(By.xpath("//div[@id='box-campaigns']//a/div[4]/s"));
    WebElement campaignPromoPrice = wd.findElement(By.xpath("//div[@id='box-campaigns']//a/div[4]/strong"));
    ProductVerification pd1 = new ProductVerification(campaignName, campaignRegularPrice, campaignPromoPrice);

    Assert.assertTrue(pd1.regularPrice());
    Assert.assertTrue(pd1.promoPrice());
    Assert.assertTrue(pd1.promoPriceFont()>pd1.regularPriceFont());

    wd.findElement(By.xpath("//div[@id='box-campaigns']//a[1]")).click();

    WebElement productName = wd.findElement(By.xpath("//div[@id='box-product']/div[1]/h1"));
    WebElement productRegularPrice = wd.findElement(By.xpath("//div[@id='box-product']/div[2]/div[2]/div[2]/s"));
    WebElement productPromoPrice = wd.findElement(By.xpath("//div[@id='box-product']/div[2]/div[2]/div[2]/strong"));
    ProductVerification pd2 = new ProductVerification(productName, productRegularPrice, productPromoPrice);

    Assert.assertTrue(pd2.regularPrice());
    Assert.assertTrue(pd2.promoPrice());
    Assert.assertTrue(pd2.promoPriceFont()>pd2.regularPriceFont());

    wd.findElement(By.xpath("//div[@class='content']//div//a[contains(text(),'Home')]")).click();

    Assert.assertEquals(pd1.productInfo(), pd2.productInfo());
    wd.quit();
  }
}