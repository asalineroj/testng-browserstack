package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest05 extends BrowserStackTestNGTest {

    @Test
    public void test_05() throws Exception {
        driver.get("https://www.google.com/ncr");
        nameTest("Request Payment");
        Thread.sleep(7000);
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack Test 05");
        element.submit();
        markTest("passed","");
        Thread.sleep(7000);


        Assert.assertEquals("BrowserStack Test 05 - Google Search", driver.getTitle());
    }
}
