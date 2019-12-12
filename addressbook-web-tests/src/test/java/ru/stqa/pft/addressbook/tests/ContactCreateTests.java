package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
/**
 * Created by Андрей on 06.12.2019.
 */
public class ContactCreateTests extends TestBase{

  @Test (enabled = false)
  public void testContactCreation(){
    app.getGroupHelper().returnToGroupPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("test_name","test_surname","test2"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }

}
