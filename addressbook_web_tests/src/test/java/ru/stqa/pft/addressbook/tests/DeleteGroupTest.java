package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class DeleteGroupTest extends TestBase {

  @Test
  public void testDeleteGroup(){
    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group", "header", "footer"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(0);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size()-1);
    app.logout();
  }
}
