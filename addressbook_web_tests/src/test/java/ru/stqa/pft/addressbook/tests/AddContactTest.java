package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AddContactTest extends TestBase {

  @Test(enabled = true)
  public void testAddContact() {
    Set<ContactData> before = app.contact().all();
    ContactData contactForm = new ContactData().withName("David").withLastName("John").withNickName("DJ").withTitle("CEO")
    .withCompanyName("ABC").
            withCompanyAddress("555 First Line").
            withHomePhone("55555555").
            withMobilePhone("777777777").
            withWorkPhone("999999999").
            withEmail("dj@gmail.com").
            withCompanyURL("www.abc.com").
            withYear("1979").
            withMonth("December").
            withDay("10").
            withSecondAddress("202020").
            withSecondPhone("101010").
            withNote("bla").
            withGroup("group");
    app.contact().createNew(contactForm);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contactForm.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add(contactForm);
    Assert.assertEquals(after, before);
  }


}
