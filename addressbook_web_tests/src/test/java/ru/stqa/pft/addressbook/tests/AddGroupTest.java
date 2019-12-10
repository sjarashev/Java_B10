package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class AddGroupTest extends TestBase {

  @Test
  public void testAddGroup() {

    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("group", "header", "footer"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before+1);
    app.logout();
  }
}
