package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ModifyContactTest extends TestBase {

  @Test
  public void testModifyContact() {
    app.getContactHelper().modifyContactPage();
    app.getContactHelper().addPersonalInfo(new PersonalData("Mark", "Robinson", "MR"));
    app.getContactHelper().addTitle("COO");
    app.getContactHelper().addCompanyInfo(new CompanyData("CBA", "123 second line"));
    app.getContactHelper().addContactInfo(new ContactData("www.cba.com", "mr@gmail.com", "888888", "33333333", "5523423432"));
    app.getContactHelper().addBirthDate(new DOBdata("1979", "November", "11"));
    app.getContactHelper().additionalInfo(new AdditionalData("blabla", "secondPhone", "second line"));
    app.getContactHelper().submitUpdatedContact();
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }
}
