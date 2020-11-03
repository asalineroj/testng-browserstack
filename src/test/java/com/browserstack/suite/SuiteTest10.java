package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest10 extends BrowserStackTestNGTest {

    @Test
    public void test_10() throws Exception {
        driver.get("https://www.google.com/ncr");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack Test 10");
        element.submit();
        nameTest("Access Account");
        markTest("passed","");
        Thread.sleep(2500);
        Assert.assertEquals("BrowserStack Test 10 - Google Search", driver.getTitle());
    }
}
