package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().all().size()==0){
      app.contact().create(new ContactData().withName("David").withLastName("John").withNickName("DJ").withTitle("CEO"));
    }
  }

  @Test(enabled = true)
  public void testDeleteContact() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() -1));
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
