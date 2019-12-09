package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class ModifyGroupTest extends TestBase {

  @Test
  public void testModifyGroup() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group", "header", "footer"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroupPage();
    app.getGroupHelper().fillGroupForm(new GroupData("group updated", "header updated", "footer updated"));
    app.getGroupHelper().submitUpdatedGroup();
    app.getGroupHelper().returnToGroupPage();
    app.logout();
  }

}
