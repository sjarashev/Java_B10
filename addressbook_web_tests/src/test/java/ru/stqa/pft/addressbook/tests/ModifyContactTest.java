package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ModifyContactTest extends TestBase {

  private ContactData conData = new ContactData("Mark", "Robinson", "MR", "COO");

  @Test
  public void testModifyContact() {
    app.getContactHelper().modifyContactPage();
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
    app.getContactHelper().submitUpdatedContact();
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }
}
