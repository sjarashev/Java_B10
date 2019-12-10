package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.HashSet;
import java.util.List;

public class ModifyGroupTest extends TestBase {

  @Test
  public void testModifyGroup() {
    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group", "header", "footer"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().modifyGroupPage();
    GroupData group = new GroupData(before.get(before.size()-1).getId(),"group updated", "header updated", "footer updated");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitUpdatedGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size()-1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    app.logout();
  }
}
