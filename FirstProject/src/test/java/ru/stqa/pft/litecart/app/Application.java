package ru.stqa.pft.litecart.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.litecart.pages.CheckoutPage;
import ru.stqa.pft.litecart.pages.MainPage;
import ru.stqa.pft.litecart.pages.ProductPage;

public class Application {

  private WebDriver driver;
  private MainPage mainPage;
  private ProductPage productPage;
  private CheckoutPage checkoutPage;
  private String browser;

  public Application(String browser) {
    this.browser = browser;
  }

  public void openWebPage() {
    if (browser.equals(BrowserType.FIREFOX)) {
      driver = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      driver = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      driver = new InternetExplorerDriver();
    }
    driver.get("http://localhost/litecart/en/");
    driver.manage().window().maximize();
    mainPage = new MainPage(driver);
    productPage = new ProductPage(driver);
    checkoutPage = new CheckoutPage(driver);
  }

  public void fillCartWithProducts(int product) {
    for (int i = 0; i < product; i++) {
      mainPage.openProduct();
      productPage.selectSizeOfTheProduct();
      productPage.addProductToTheCart();
      productPage.checkItemsInCart(i + 1);
      productPage.goToMainPage();
    }
  }
  public void goToCheckout() {
    productPage.checkout.click();
  }
  public void deleteProductsFromTheCart(int number){
    checkoutPage.deleteProductFromTheCart(number);
  }
  public void quit() {
    driver.quit();
  }
}
