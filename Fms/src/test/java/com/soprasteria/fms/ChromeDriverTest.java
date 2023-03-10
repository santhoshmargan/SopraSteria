package com.soprasteria.fms;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTest {
  @Test
  public void testGoogleSearch() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\smargan\\ChromeDriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.com/");
    Thread.sleep(5000); // Let the user actually see something!
    WebElement searchBox = driver.findElement(By.name("q"));
    searchBox.sendKeys("ChromeDriver");
    searchBox.submit();
    Thread.sleep(5000); // Let the user actually see something!
    driver.quit();
  }
}
