package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ModifyContactTest extends TestBase {

  @Test
  public void testModifyContact() {
    ContactData conData = new ContactData("Mark", "Robinson", "MR", "COO");
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
    conData.setGroup(null);
    app.getContactHelper().fillContactForm(conData, false);
    app.getContactHelper().submitUpdatedContact();
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }
}
