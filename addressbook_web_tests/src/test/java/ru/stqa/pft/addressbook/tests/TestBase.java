package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sun.plugin2.util.BrowserType;


public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.MOZILLA);

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

}
