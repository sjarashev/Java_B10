package ru.stqa.pft.litecart.firstPackage;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.litecart.appmanager.PersonalData;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class GettingStarted extends TestBase {

  @Test(enabled = false)
  public void loopThroughMenuItems() {
    wd.get("http://localhost/litecart/admin/");
    wd.manage().window().maximize();
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
  }

  @Test(enabled = false)
  public void checkStickers() {
    wd.get("http://localhost/litecart/en/");
    wd.manage().window().maximize();
    List<WebElement> ducks = wd.findElements(By.xpath("//li[contains(@class, 'product')]"));

    for (WebElement duck : ducks) {
      int sticker = duck.findElements(By.xpath(".//div[contains(@class, 'sticker')]")).size();
      if (sticker > 0) {
        assertEquals(sticker, 1);
        System.out.println(sticker);
      }
    }
    wd.quit();
  }

  @Test(enabled = false)
  public void checkAlphaOrder() throws InterruptedException {
    wd.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    wd.manage().window().maximize();
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
      if (Integer.parseInt(w.findElement(By.xpath("./td[6]")).getText().trim()) > 0) {
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
    wd.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    wd.manage().window().maximize();
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

  @Test(enabled = false)
  public void checkCampaignsItem() throws InterruptedException {
    wd.get("http://localhost/litecart/en/");
    wd.manage().window().maximize();
    WebElement campaignName = wd.findElement(By.xpath("//div[@id='box-campaigns']//a/div[2]"));
    WebElement campaignRegularPrice = wd.findElement(By.xpath("//div[@id='box-campaigns']//a/div[4]/s"));
    WebElement campaignPromoPrice = wd.findElement(By.xpath("//div[@id='box-campaigns']//a/div[4]/strong"));
    ProductVerification pd1 = new ProductVerification(campaignName, campaignRegularPrice, campaignPromoPrice);

    Assert.assertTrue(pd1.regularPrice());
    Assert.assertTrue(pd1.promoPrice());
    Assert.assertTrue(pd1.promoPriceFont() > pd1.regularPriceFont());

    wd.findElement(By.xpath("//div[@id='box-campaigns']//a[1]")).click();

    WebElement productName = wd.findElement(By.xpath("//div[@id='box-product']/div[1]/h1"));
    WebElement productRegularPrice = wd.findElement(By.xpath("//div[@id='box-product']/div[2]/div[2]/div[2]/s"));
    WebElement productPromoPrice = wd.findElement(By.xpath("//div[@id='box-product']/div[2]/div[2]/div[2]/strong"));
    ProductVerification pd2 = new ProductVerification(productName, productRegularPrice, productPromoPrice);

    Assert.assertTrue(pd2.regularPrice());
    Assert.assertTrue(pd2.promoPrice());
    Assert.assertTrue(pd2.promoPriceFont() > pd2.regularPriceFont());

    wd.findElement(By.xpath("//div[@class='content']//div//a[contains(text(),'Home')]")).click();

    Assert.assertEquals(pd1.productInfo(), pd2.productInfo());
    wd.quit();
  }

  private void type(By locator, String text) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  @Test
  public void userRegistration() throws Exception {
    wd.get("http://localhost/litecart/en/");
    wd.manage().window().maximize();
    wd.findElement(By.linkText("New customers click here")).click();
    type(By.name("firstname"), "David");
    type(By.name("lastname"), "John");
    type(By.name("tax_id"), "123");
    type(By.name("company"), "abc");
    type(By.name("address1"), "123 first line");
    type(By.name("postcode"), "12345");
    type(By.name("city"), "NY");
    type(By.name("email"), "davidj@abc.com");
    type(By.name("phone"), "1234567890");
    type(By.name("password"), "123");
    type(By.name("confirmed_password"), "123");
    new Select(wd.findElement(By.name("zone_code"))).selectByVisibleText("Ontario");
    wd.findElement(By.xpath("//span[@class='select2-selection__arrow']")).click();
    wd.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("United States", Keys.ENTER);

    if (wd.findElement(By.xpath("//input[@name='newsletter']")).getAttribute("checked").equals("false")){
      wd.findElement(By.xpath("//input[@name='newsletter']")).click();
    }
    wd.findElement(By.name("create_account")).click();
    wd.findElement(By.linkText("Logout")).click();
    type(By.name("email"), "david@abc.com");
    type(By.name("password"), "123");
    wd.findElement(By.name("login")).click();
    wd.findElement(By.linkText("Logout")).click();
  }
}