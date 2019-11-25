package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.*;

public class AddContactTest extends TestBase {


  @Test
  public void testAddContact() throws Exception {
    app.gotoAddContactPage();
    app.addPersonalInfo(new PersonalData("David", "John", "DJ"));
    app.addTitle("CEO");
    app.addCompanyInfo(new CompanyData("ABC", "555 first line"));
    app.addContactInfo(new ContactData("www.abc.com", "dj@gmail.com", "777777", "9999999", "555555"));
    app.addBirthDate(new DOBdata("1979", "December", "10"));
    app.additionalInfo(new AdditionalData("bla", "secondPhone", "second line"));
    app.submitForm();
    app.gotoHomePage();
    app.logout();
  }
}
