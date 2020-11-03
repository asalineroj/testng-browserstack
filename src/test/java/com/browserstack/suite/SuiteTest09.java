package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest09 extends BrowserStackTestNGTest {

    @Test
    public void test_09() throws Exception {
        driver.get("https://bank.barclays.co.uk/olb/authlogin/loginAppContainer.do#/identification");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("surname0"));
        element.sendKeys("Doe");
        Thread.sleep(3000);
//        element.submit();
        Thread.sleep(3000);
        nameTest("Open Account");
        Assert.assertEquals("BrowserStack Test 09 - Google Search", driver.getTitle());
    }
}
