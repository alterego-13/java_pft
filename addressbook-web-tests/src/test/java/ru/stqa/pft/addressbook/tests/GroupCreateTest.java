package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreateTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";

    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
      // String[] split = line.split(";");
      // list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});

    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
    return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

    /* создание данных
    list.add(new Object[]{new GroupData().withName("test1").withHeader("header 1").withFooter("footer 1")});
    list.add(new Object[]{new GroupData().withName("test2").withHeader("header 2").withFooter("footer 2")});
    list.add(new Object[]{new GroupData().withName("test3").withHeader("header 3").withFooter("footer 3")});*/


  }


  @Test(dataProvider = "validGroups")
  public void testCreateGroupCase(GroupData group) {

    // GroupData group = new GroupData().withName(name).withHeader(header).withFooter(footer);
    app.group().returnToGroupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
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
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();


    assertThat(after, equalTo(before));
  }

}


