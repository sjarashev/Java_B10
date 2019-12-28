package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.List;

public class DeleteContactTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().list().size()==0){
      app.contact().create(new ContactData().withName("David").withLastName("John").withNickName("DJ").withTitle("CEO"));
    }
  }

  @Test(enabled = true)
  public void testDeleteContact() {
    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    app.contact().delete(index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(index);
    Assert.assertEquals(before,after);
  }
}
