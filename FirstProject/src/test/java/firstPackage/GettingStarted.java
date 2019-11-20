package firstPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

public class GettingStarted {
  @Test
  public void openGooglePage() throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\sjarashev\\Desktop\\Java Training\\Java_B10\\FirstProject\\Webdriver\\chromedriver_V78.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.com/");
    Thread.sleep(1000);
    driver.manage().window().maximize();
    Thread.sleep(2000);
    driver.quit();
  }
}

