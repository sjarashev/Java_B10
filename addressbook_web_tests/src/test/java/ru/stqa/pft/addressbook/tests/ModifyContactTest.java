package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.Comparator;
import java.util.List;

public class ModifyContactTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().list().size()==0){
      app.contact().create(new ContactData().withName("David").withLastName("John").withNickName("DJ").withTitle("CEO"));
    }
  }

  @Test(enabled = true)
  public void testModifyContact() throws InterruptedException {
    List<ContactData> before = app.contact().list();
    ContactData contactForm = new ContactData().withId(before.get(before.size()-1).getId())
            .withName("Mark").withLastName("Robinson").withNickName("MR").withTitle("COO");
    contactForm.setCompanyName("CBA");
    contactForm.setCompanyAddress("777 Third Line");
    contactForm.setHomePhone("797979");
    contactForm.setMobilePhone("5252525");
    contactForm.setWorkPhone("454545");
    contactForm.setEmail("mr@gmail.com");
    contactForm.setCompanyURL("www.cba.com");
    contactForm.setYear("1980");
    contactForm.setMonth("November");
    contactForm.setDay("11");
    contactForm.setSecondAddress("45245245");
    contactForm.setSecondPhone("858585");
    contactForm.setNote("blabla");
    contactForm.setGroup(null);
    int index = before.size()-1;
    app.contact().modify(contactForm, index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contactForm);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
