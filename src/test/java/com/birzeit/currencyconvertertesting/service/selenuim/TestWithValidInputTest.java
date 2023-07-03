package com.birzeit.currencyconvertertesting.service.selenuim;// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class TestWithValidInputTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() throws MalformedURLException {
    driver = new RemoteWebDriver(new URL("http://127.0.0.1:5500/index.html"), DesiredCapabilities.chrome());
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testWithValidInput() {
    // Test name: testWithValidInput
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("http://127.0.0.1:5500/");
    // 2 | setWindowSize | 782x654 | 
    driver.manage().window().setSize(new Dimension(782, 654));
    // 3 | click | id=toCurrency | 
    driver.findElement(By.id("toCurrency")).click();
    // 4 | select | id=toCurrency | label=ARS
    {
      WebElement dropdown = driver.findElement(By.id("toCurrency"));
      dropdown.findElement(By.xpath("//option[. = 'ARS']")).click();
    }
    // 5 | click | id=fromCurrency | 
    driver.findElement(By.id("fromCurrency")).click();
    // 6 | select | id=fromCurrency | label=BMD
    {
      WebElement dropdown = driver.findElement(By.id("fromCurrency"));
      dropdown.findElement(By.xpath("//option[. = 'BMD']")).click();
    }
    // 7 | click | id=amount | 
    driver.findElement(By.id("amount")).click();
    // 8 | type | id=amount | 1003
    driver.findElement(By.id("amount")).sendKeys("1003");
    // 9 | click | id=convertButton | 
    driver.findElement(By.id("convertButton")).click();
  }
}