package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreateTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new GroupData().withName("test1").withHeader("header 1").withFooter("footer 1")});
    list.add(new Object[]{new GroupData().withName("test2").withHeader("header 2").withFooter("footer 2")});
    list.add(new Object[]{new GroupData().withName("test3").withHeader("header 3").withFooter("footer 3")});
    return list.iterator();


  }


  @Test(dataProvider = "validGroups")
  public void testCreateGroupCase(GroupData group) {

    // GroupData group = new GroupData().withName(name).withHeader(header).withFooter(footer);
    app.group().returnToGroupPage();
    Groups before = app.group().all();
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(app.group().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo
            (before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }


  //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());


  // before.add(group);
  // Assert.assertEquals(before,after);


  @Test
  public void testBadCreateGroupCase() throws Exception {
    app.group().returnToGroupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();


    assertThat(after, equalTo(before));
  }

}


