package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class ContactInGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().createPartial(new ContactData().withName("David").withLastName("John").withTitle("CEO")
              .withCompanyName("ABC").withCompanyAddress("3rd Line"));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("group").withHeader("header").withFooter("footer"));
      app.goTo().homePage();
    }
  }

  @Test(enabled = true)
  public void testAddContactIntoGroup() {
    ContactData contact = app.db().contacts().iterator().next();
    GroupData group = app.db().groups().iterator().next();
    Contacts contacts = group.getContacts();
    int before = contact.getGroups().size();

    if (group.getContacts().size() == 0) {
      app.contact().selectAndAdd(contact, group.getName());
      contact = app.db().contacts().iterator().next();
      int after = contact.getGroups().size();
      Assert.assertTrue(after>before);

    } else {
      for (ContactData conData : contacts) {

        if (contact.getId() != conData.getId()) {
          app.contact().selectAndAdd(contact, group.getName());
          contact = app.db().contacts().iterator().next();
          int after = contact.getGroups().size();
          Assert.assertTrue(after>before);
          break;

        } else {
          String name = "newGroup";
          app.goTo().groupPage();
          app.group().create(new GroupData().withName(name).withHeader("header").withFooter("footer"));
          app.goTo().homePage();
          app.contact().selectAndAdd(contact, name);
          contact = app.db().contacts().iterator().next();
          int after = contact.getGroups().size();
          Assert.assertTrue(after>before);
        }
      }
    }
  }


  @Test(enabled = true)
  public void testRemoveContactFromGroup() {
    ContactData contact = app.db().contacts().iterator().next();
    Groups groups = contact.getGroups();
    int before = contact.getGroups().size();
    if (contact.getGroups().size() > 0) {
      for (GroupData group : groups) {
        app.contact().selectAndRemove(contact, group);
        app.goTo().homePage();
      }
    }
    contact = app.db().contacts().iterator().next();
    int after = contact.getGroups().size();
    Assert.assertTrue(after<before);
  }
}
