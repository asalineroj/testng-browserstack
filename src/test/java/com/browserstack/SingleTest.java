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
        driver.get("https://www.nordea.com/en/");
        percy.snapshot("Home Page");
        Thread.sleep(2000);
       
        percy.snapshot("Log In Page");
//
        WebElement email = driver.findElement(By.name("q"));
//       email.sendKeys("bt");
        WebElement cookiesBanner = driver.findElement(By.className("wscrOk"));
        cookiesBanner.click();
        //confirm.sendKeys("andres@browserstack.com");
//        WebElement password = driver.findElement(By.id("password"));
//        password.sendKeys("password");
//        WebElement displayname = driver.findElement(By.id("displayname"));
//        displayname.sendKeys("displayname");
//       driver.get("https://www.google.ie/search?source=hp&ei=-gcdYJXmAbeAhbIPl8iesA0&q=mongodb&oq=mongodb&gs_lcp=CgZwc3ktYWIQAzIFCAAQsQMyCAgAELEDEIMBMggILhDHARCvATIICAAQsQMQgwEyAggAMgIIADICCAAyAggAMgIIADICCAA6CAgAEOoCEI8BOgsILhCxAxDHARCjAjoICC4QsQMQgwE6DgguELEDEMcBEK8BEJMCOggILhDHARCjAjoCCC46CwguEMcBEKMCEJMCOgsILhCxAxDHARCvAToFCC4QsQM6CwguELEDEIMBEJMCUIobWIEiYMMjaAFwAHgAgAF-iAHEA5IBAzYuMZgBAKABAaoBB2d3cy13aXqwAQo&sclient=psy-ab&ved=0ahUKEwiVy9vXr9LuAhU3QEEAHRekB9YQ4dUDCAc&uact=5");
//        WebElement day = driver.findElement(By.id("day"));
//
//        WebElement month = driver.findElement(By.id("month"));
//
//        WebElement year = driver.findElement(By.id("year"));


        nameTest("Home");
//        try{
//            assertEquals("BrowserStack - Google Search".toLowerCase(), driver.getTitle().toLowerCase());
//        } catch (AssertionError e){
//            markTest("failed","Title Did not match");
//            throw e;
//        }
        markTest("passed","");
        System.out.print("Now To Percy...");
    }
}
