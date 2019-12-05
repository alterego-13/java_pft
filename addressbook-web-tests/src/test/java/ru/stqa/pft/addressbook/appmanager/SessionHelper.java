package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Андрей on 04.12.2019.
 */
public class SessionHelper extends HelperBase {


  public SessionHelper(WebDriver driver) {
    super(driver);
  }

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    /*driver.findElement(By.xpath("//img[@alt='Address book']")).click();
    driver.findElement(By.id("content")).click();
    driver.findElement(By.id("LoginForm")).click();
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(username);*/
    //driver.findElement(By.xpath("//*/text()[normalize-space(.)='']/parent::*")).click();
   /* driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(password);*/
    click(By.xpath("//input[@value='Login']"));
  }
}

