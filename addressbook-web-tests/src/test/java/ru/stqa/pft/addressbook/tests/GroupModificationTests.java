package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Андрей on 05.12.2019.
 */
public class GroupModificationTests extends TestBase {
  @Test

  public void testGroupModification() {
    app.getGroupHelper().returnToGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(before -1 );
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test3", "test4", "test5"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);

  }
}
