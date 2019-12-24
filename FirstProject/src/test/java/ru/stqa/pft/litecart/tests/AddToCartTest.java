package ru.stqa.pft.litecart.tests;

import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

  @Test(enabled = true)
  public void addToCart() throws InterruptedException {
    app.fillCartWithProducts(3);
    app.goToCheckout();
    app.deleteProductsFromTheCart(3);
    app.quit();
  }
}
