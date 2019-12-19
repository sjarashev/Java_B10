package ru.stqa.pft.litecart.firstPackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TestBase {

  FirefoxDriver wd;

  @BeforeMethod
  public void init() {
    //System.setProperty("webdriver.gecko.driver", "C:\\Users\\sjarashev\\Desktop\\Java Training\\Java_B10\\FirstProject\\webdriver\\geckodriver0.24_win64.exe");
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    //wd.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    //wd.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    //wd.get("http://localhost/litecart/en/");
    //wd.manage().window().maximize();
  }
}
