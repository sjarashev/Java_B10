package ru.stqa.pft.litecart.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.litecart.app.Application;

public class TestBase {
  final Application app = new Application(BrowserType.FIREFOX);

  @BeforeMethod
  public void init() {
    app.openWebPage();
  }
}
