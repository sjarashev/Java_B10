package ru.stqa.pft.litecart.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProductPage extends Page {
  public ProductPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//select[@name='options[Size]']")
  private WebElement sizeSelectionDropdown;

  @FindBy(xpath = "//button[@name='add_cart_product']")
  private WebElement addProduct;

  @FindBy(xpath = "//span[@class='quantity']")
  private WebElement itemsInCart;

  @FindBy(xpath = "//li[@class='general-0']//a")
  private WebElement goToMainPage;

  @FindBy(xpath = "//a[contains(text(),'Checkout »')]")
  public WebElement checkout;

  public void addProductToTheCart() {
    addProduct.click();
    Alert alert = wait.until(alertIsPresent());
    alert.accept();
  }

  public void selectSizeOfTheProduct() {
    if (isElementPresent(By.xpath("//select[@name='options[Size]']"))) {
      new Select(sizeSelectionDropdown).selectByVisibleText("Small");
    }
  }

  private boolean isElementPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }

  public void checkItemsInCart(int items) {
    driver.navigate().refresh();
    itemsInCart = driver.findElement(By.xpath("//span[@class='quantity']"));
    wait.until(textToBePresentInElement(itemsInCart, String.valueOf(items)));
  }

  public void goToMainPage(){
    goToMainPage.click();
  }
}
