package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.percy.selenium.Percy;
import static org.junit.Assert.assertEquals;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        driver.get("https://www.google.com/ncr");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack");
        element.submit();
        Thread.sleep(5000);
        percy.snapshot("Home Page");

        try{
            assertEquals("BrowserStack - Google Search".toLowerCase(), driver.getTitle().toLowerCase());
        } catch (AssertionError e){
            markTest("failed","Title Did not match");
            throw e;
        }
        markTest("passed"," Title Matched");
        System.out.print("Now To Percy...");
    }
}
