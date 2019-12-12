package ru.stqa.pft.litecart.firstPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

class TestHelper {

  //private List<String> newList = new ArrayList<>();

  List<String> createListOf(List<WebElement> we) {
    List<String> newList = new ArrayList<>();
    for (WebElement webElement : we) {
      if (webElement.getText() != null && !webElement.getText().trim().equals("")) {
        newList.add(webElement.getText());
      }
    }
    return newList;
  }

  void sort(List<String> we) {

    String previousWe, currentWe;
    previousWe = we.get(0);
    for (int i = 1; i < we.size(); i++) {
      currentWe = we.get(i);
      if (previousWe.trim().toLowerCase().compareTo(currentWe.trim().toLowerCase()) > 0) {
        Assert.fail();
        return;
      } else {
        Assert.assertTrue(true);
        //System.out.println(previousWe+currentWe);
        previousWe = we.get(i);
      }
    }
  }

  List<WebElement> filter(List<WebElement> we) {
    List<WebElement> filtered = new ArrayList<>();
    for (WebElement w : we) {
      int i = Integer.parseInt(w.findElement(By.xpath(".//td[6]")).getText().trim());
      if (i > 0) {
        filtered.add(w);
      }
    }
    return filtered;
  }
}