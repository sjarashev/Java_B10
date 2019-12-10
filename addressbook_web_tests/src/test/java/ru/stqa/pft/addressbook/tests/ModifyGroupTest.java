package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class ModifyGroupTest extends TestBase {

  @Test
  public void testModifyGroup() {
    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group", "header", "footer"));
    }
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroupPage();
    app.getGroupHelper().fillGroupForm(new GroupData("group updated", "header updated", "footer updated"));
    app.getGroupHelper().submitUpdatedGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before);
    app.logout();
  }

}
