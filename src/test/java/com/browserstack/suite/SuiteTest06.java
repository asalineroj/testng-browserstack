package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest06 extends BrowserStackTestNGTest {

    @Test
    public void test_06() throws Exception {
        driver.get("https://www.google.com/ncr");
        Thread.sleep(2500);
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack Test 06");
        Thread.sleep(2500);
        element.submit();
        Thread.sleep(2500);
        nameTest("Request Loan");

        Assert.assertEquals("BrowserStack Test 06 - Google Search", driver.getTitle());
    }
}
