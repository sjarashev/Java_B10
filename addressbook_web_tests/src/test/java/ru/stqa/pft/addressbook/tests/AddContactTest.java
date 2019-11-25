package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

public class AddContactTest extends TestBase {


  @Test
  public void testAddContact() throws Exception {
    app.getContactHelper().gotoAddContactPage();
    app.getContactHelper().addPersonalInfo(new PersonalData("David", "John", "DJ"));
    app.getContactHelper().addTitle("CEO");
    app.getContactHelper().addCompanyInfo(new CompanyData("ABC", "555 first line"));
    app.getContactHelper().addContactInfo(new ContactData("www.abc.com", "dj@gmail.com", "777777", "9999999", "555555"));
    app.getContactHelper().addBirthDate(new DOBdata("1979", "December", "10"));
    app.getContactHelper().additionalInfo(new AdditionalData("bla", "secondPhone", "second line"));
    app.getContactHelper().submitForm();
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }
}
