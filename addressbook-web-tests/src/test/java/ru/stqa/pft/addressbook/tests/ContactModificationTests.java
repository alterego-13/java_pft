package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Андрей on 06.12.2019.
 */
public class ContactModificationTests extends TestBase {
  @Test

  public void testContactModification() {
    {
      app.getGroupHelper().returnToGroupPage();

      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", null), false);
      app.getContactHelper().submitContactModification();
      app.getContactHelper().returnToHomePage();

    }
  }
}