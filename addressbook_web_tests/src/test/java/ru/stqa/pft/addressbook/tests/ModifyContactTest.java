package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ModifyContactTest extends TestBase {

  @Test
  public void testModifyContact() throws InterruptedException {
    if (app.getContactHelper().thereIsNoContact()){
      app.getContactHelper().createContact(new ContactData("David", "John", "DJ", "CEO"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().modifyContactPage(before.size()-1);
    ContactData conData = new ContactData(before.get(before.size()-1).getId(),"Mark", "Robinson", "MR", "COO");
    conData.setCompanyName("CBA");
    conData.setCompanyAddress("777 Third Line");
    conData.setHomePhone("797979");
    conData.setMobilePhone("5252525");
    conData.setWorkPhone("454545");
    conData.setEmail("mr@gmail.com");
    conData.setCompanyURL("www.cba.com");
    conData.setYear("1980");
    conData.setMonth("November");
    conData.setDay("11");
    conData.setSecondAddress("45245245");
    conData.setSecondPhone("858585");
    conData.setNote("blabla");
    conData.setGroup(null);
    app.getContactHelper().fillContactForm(conData, false);
    app.getContactHelper().submitUpdatedContact();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(conData);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    app.logout();
  }
}
