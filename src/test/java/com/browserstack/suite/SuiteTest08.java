package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest08 extends BrowserStackTestNGTest {

    @Test
    public void test_08() throws Exception {
        driver.get("https://www.google.com/ncr");
        nameTest("Send Proof of Residence");
        Thread.sleep(2500);
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack Test 08");
        element.submit();
        markTest("passed","");
        Thread.sleep(2500);

        Assert.assertEquals("BrowserStack Test 08 - Google Search", driver.getTitle());
    }
}
