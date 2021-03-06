package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Андрей on 05.12.2019.
 */
public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.group().returnToGroupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test

  public void testGroupModification() {


    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
//    int index = before.size() - 1;
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test3").withHeader("test4").withFooter("test5");
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();

    // assertEquals(after.size(), before.size());
    before.remove(modifiedGroup);
    before.add(group);
  /*  Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);*/
    assertEquals(before, after);
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

  }


}
