package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.remote.BrowserType;


public class TestBase {

  final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

}
