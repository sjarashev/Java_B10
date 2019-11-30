package ru.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

class HelperBase {
  FirefoxDriver wd;

  HelperBase(FirefoxDriver wd) {
    this.wd = wd;
  }

  void click(By locator) {
    wd.findElement(locator).click();
  }

  void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  void closeAttentionDialog() {
    wd.switchTo().alert().accept();
  }

  }

