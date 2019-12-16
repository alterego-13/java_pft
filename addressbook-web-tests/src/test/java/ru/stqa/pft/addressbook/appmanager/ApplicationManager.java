package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {
  protected WebDriver driver;

  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  public String baseUrl;
  public StringBuffer verificationErrors;
  private boolean acceptNextAlert = true;
  private String browser;

  public ApplicationManager(String browser) {

    this.browser = browser;
  }

  final String s = System.setProperty("webdriver.gecko.driver", "C://Program Files//Mozilla Firefox/geckodriver.exe");

  public void init() {
    //String browser = BrowserType.FIREFOX;
    if (Objects.equals(browser, BrowserType.FIREFOX)) {
      driver = new FirefoxDriver();
    } else if (Objects.equals(browser, BrowserType.CHROME)) {
      driver = new ChromeDriver();
    } else if (Objects.equals(browser, BrowserType.IE)) {
      driver = new InternetExplorerDriver();
    }


    baseUrl = "http://www.google.com/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(driver);
    contactHelper = new ContactHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }


  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}