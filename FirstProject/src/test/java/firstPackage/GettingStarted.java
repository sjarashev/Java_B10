package firstPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class GettingStarted {

  @Test
  public void loginToLitecard() throws Exception {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\sjarashev\\Desktop\\Java Training\\Java_B10\\FirstProject\\webdriver\\chromedriver_T78.exe");
    WebDriver driver = new ChromeDriver();

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



