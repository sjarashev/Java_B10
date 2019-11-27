package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class DeleteContactTest extends TestBase {

  @Test
  public void testDeleteContact() {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAttention();
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }
}
