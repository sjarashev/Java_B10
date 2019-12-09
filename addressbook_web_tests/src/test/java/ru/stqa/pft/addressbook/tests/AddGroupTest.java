package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class AddGroupTest extends TestBase {

  @Test
  public void testAddGroup() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("group", "header", "footer"));
    app.logout();
  }
}
