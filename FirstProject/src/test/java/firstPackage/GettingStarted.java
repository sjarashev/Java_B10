package firstPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;


public class GettingStarted {



  @Test
  public void loginToLitecard() {

    System.setProperty("webdriver.gecko.driver", "C:\\Users\\sjarashev\\Desktop\\Java Training\\Java_B10\\FirstProject\\webdriver\\geckodriver0.24_win64.exe");
    WebDriver driver = new FirefoxDriver();

    // старая схема более явно (этот способ указания опций рекомендуется, начиная с версии 3.3):
    //FirefoxOptions options = new FirefoxOptions().setLegacy(true);
    //WebDriver driver = new FirefoxDriver(options);

    //старая схема (при использовании Selenium до версии 3.3):
    //DesiredCapabilities caps = new DesiredCapabilities();
    //caps.setCapability(FirefoxDriver.MARIONETTE, true);
    //WebDriver driver = new FirefoxDriver(caps);

     //при использовании Selenium 3.3 и новее, с девелоперской версией или FirefoxNightly:
    //System.setProperty("webdriver.gecko.driver", "C:\\Users\\sjarashev\\Desktop\\Java Training\\Java_B10\\FirstProject\\webdriver\\geckodriver0.24_win64.exe");
    //FirefoxOptions options = new FirefoxOptions();
    //options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Nightly\\firefox.exe")));
    //WebDriver driver = new FirefoxDriver(options);

    // при использовании версий до 3.3 , с девелоперской версией или FirefoxNightly:
    //FirefoxBinary bin = new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe"));
    //WebDriver driver = new FirefoxDriver(bin, new FirefoxProfile());

    try {
      driver.get("http://localhost/litecart/admin");
      Thread.sleep(1000);
      driver.manage().window().maximize();
      Thread.sleep(1000);
      driver.findElement(By.name("username")).sendKeys("admin");
      Thread.sleep(1000);
      driver.findElement(By.name("password")).sendKeys("admin");
      Thread.sleep(1000);
      driver.findElement(By.name("login")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//span[contains(text(), 'Appearence')]")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//span[contains(text(), 'Template')]")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//i[contains(@class, 'fa fa-sign-out fa-lg')]")).click();
      Thread.sleep(2000);
      driver.quit();

    } catch (Exception e) {
      System.out.println(e);
      driver.quit();
    }
  }
}



