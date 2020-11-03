package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest04 extends BrowserStackTestNGTest {

    @Test
    public void test_04() throws Exception {
        driver.get("https://www.google.com/ncr");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack Test 04");
        element.submit();
        nameTest("Send Payment");
        Thread.sleep(2500);
        markTest("passed","");
        Assert.assertEquals("BrowserStack Test 04 - Google Search", driver.getTitle());
    }
}
