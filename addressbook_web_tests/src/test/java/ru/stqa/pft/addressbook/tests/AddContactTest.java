package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddContactTest extends TestBase {

  @Test
  public void testAddContact() {
    ContactData conData = new ContactData("David", "John", "DJ", "CEO");
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoAddContactPage();
    conData.setCompanyName("ABC");
    conData.setCompanyAddress("555 First Line");
    conData.setHomePhone("55555555");
    conData.setMobilePhone("777777777");
    conData.setWorkPhone("999999999");
    conData.setEmail("dj@gmail.com");
    conData.setCompanyURL("www.abc.com");
    conData.setYear("1979");
    conData.setMonth("December");
    conData.setDay("10");
    conData.setSecondAddress("202020");
    conData.setSecondPhone("101010");
    conData.setNote("bla");
    conData.setGroup("group");
    app.getContactHelper().fillContactForm(conData, true);
    app.getContactHelper().submitForm();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(conData);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    app.logout();
  }
}
