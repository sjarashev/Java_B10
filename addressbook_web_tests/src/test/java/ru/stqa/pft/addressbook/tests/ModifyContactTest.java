package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ModifyContactTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("David").withLastName("John").withNickName("DJ").withTitle("CEO"));
    }
  }

  @Test(enabled = true)
  public void testModifyContact() throws InterruptedException {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contactForm = new ContactData().withId(modifiedContact.getId())
            .withName("Mark").withLastName("Robinson").withNickName("MR").withTitle("COO")
            .withCompanyName("CBA").
                    withCompanyAddress("777 Third Line").
                    withHomePhone("797979").
                    withMobilePhone("5252525").
                    withWorkPhone("454545").
                    withEmail("mr@gmail.com").
                    withCompanyURL("www.cba.com").
                    withYear("1980").
                    withMonth("November").
                    withDay("11").
                    withSecondAddress("45245245").
                    withSecondPhone("858585").
                    withNote("blabla").
                    withGroup(null);
    app.contact().modify(contactForm);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contactForm);
    Assert.assertEquals(before, after);
  }
}
