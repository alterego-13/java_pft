package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreateTest extends TestBase {


  @Test
  public void testCreateGroupCase() throws Exception {

    returnToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
