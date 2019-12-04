package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Андрей on 04.12.2019.
 */
public class NavigationHelper {
  private WebDriver driver;

  public NavigationHelper(WebDriver driver) {
    this.driver = driver;
  }

  public void gotoGroupPage() {
    driver.findElement(By.linkText("groups")).click();
  }
}
