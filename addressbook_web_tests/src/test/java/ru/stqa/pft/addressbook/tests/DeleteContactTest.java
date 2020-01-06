package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size()==0){
      app.goTo().homePage();
      app.contact().createPartial(new ContactData().withName("David").withLastName("John").withNickName("DJ").withTitle("CEO"));
    }
  }

  @Test(enabled = true)
  public void testDeleteContact() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.goTo().homePage();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() -1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
