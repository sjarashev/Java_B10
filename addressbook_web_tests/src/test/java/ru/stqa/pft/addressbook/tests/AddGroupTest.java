package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class AddGroupTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.gotoGroupPage();
    app.initGroupPage();
    app.fillGroupForm(new GroupData("group1", "header1", "footer1"));
    app.submitGroupCreation();
    app.returnToGroupPage();
    app.logout();
  }
}
