package ru.stqa.pft.litecart.firstPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Remote {

  private WebDriver wd = new RemoteWebDriver(new URL("http://192.168.2.19:4444/wd/hub"), new EdgeOptions());

  public Remote() throws MalformedURLException {
  }

  private String newWindow(){
    String mainWindow = wd.getWindowHandle();
    Set<String> allWindows = wd.getWindowHandles();
    String newWindow = null;
    for (String window:allWindows){
      if (!window.equals(mainWindow)){
        newWindow = window;
      }
    }return newWindow;
  }

  @Test(enabled = true)
  public void remote() throws MalformedURLException {

    wd.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    wd.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(wd, 5);
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("login")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='button']"))).click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[2]/td/a[@target]"))).click();
    String mainWindow = wd.getWindowHandle();
    wd.switchTo().window(newWindow());
    wd.close();
    wd.switchTo().window(mainWindow);

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[3]/td/a[@target]"))).click();
    wd.switchTo().window(newWindow());
    wd.close();
    wd.switchTo().window(mainWindow);

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[6]/td/a[@target]"))).click();
    wd.switchTo().window(newWindow());
    wd.close();
    wd.switchTo().window(mainWindow);

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[7]/td/a[@target]"))).click();
    wd.switchTo().window(newWindow());
    wd.close();
    wd.switchTo().window(mainWindow);

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[8]/td/a[@target]"))).click();
    wd.switchTo().window(newWindow());
    wd.close();
    wd.switchTo().window(mainWindow);

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[9]/td/a[@target]"))).click();
    wd.switchTo().window(newWindow());
    wd.close();
    wd.switchTo().window(mainWindow);

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[10]/td/a[@target]"))).click();
    wd.switchTo().window(newWindow());
    wd.close();
    wd.switchTo().window(mainWindow);

    wd.quit();
  }
}
