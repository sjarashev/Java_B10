package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

public class AddContactTest extends TestBase {

  private ContactData conData = new ContactData("David", "John", "DJ", "CEO");

  @Test
  public void testAddContact() {
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

    app.getContactHelper().addPersonalInfo(conData);
    app.getContactHelper().addCompanyName(conData);
    app.getContactHelper().addCompanyAddress(conData);
    app.getContactHelper().addHomePhone(conData);
    app.getContactHelper().addMobilePhone(conData);
    app.getContactHelper().addWorkPhone(conData);
    app.getContactHelper().addEmail(conData);
    app.getContactHelper().addCompanyURL(conData);
    app.getContactHelper().addYear(conData);
    app.getContactHelper().addMonth(conData);
    app.getContactHelper().addDay(conData);
    app.getContactHelper().addSecondAddress(conData);
    app.getContactHelper().addSecondPhone(conData);
    app.getContactHelper().addNote(conData);
    app.getContactHelper().submitForm();
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }
}
