package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GroupHelper extends HelperBase {

  private NavigationHelper navigationHelper;

  public GroupHelper(WebDriver driver) {
    super(driver);
    navigationHelper = new NavigationHelper(driver);
  }

  public void returnToGroupPage() {
    navigationHelper.gotoGroupPage();
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }


  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }


 /* public void selectGroup(int index) {
    driver.findElements
            (By.name("selected[]")).get(index).click();
  }
*/
  public void selectGroupById(int id) {
    driver.findElement
            (By.cssSelector("input[value='" + id + "']")).click();
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modify( GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }



  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    returnToGroupPage();
  }


  public boolean isThereGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return driver.findElements(By.name("selected[]")).size();
  }

 /* public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }
*/
  public Groups all() {
    Groups groups = new Groups();
    List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }
}



