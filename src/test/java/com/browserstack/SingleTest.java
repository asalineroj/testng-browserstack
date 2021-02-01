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
        driver.get("https://seb.se/");
        percy.snapshot("Home Page");
        Thread.sleep(2000);
        driver.get("https://id.seb.se/ibp/mbid");
        percy.snapshot("Log In Page");
//
//        WebElement email = driver.findElement(By.id("email"));
//        email.sendKeys("andres@browserstack.com");
//        WebElement confirm = driver.findElement(By.id("confirm"));
//        confirm.sendKeys("andres@browserstack.com");
//        WebElement password = driver.findElement(By.id("password"));
//        password.sendKeys("password");
//        WebElement displayname = driver.findElement(By.id("displayname"));
//        displayname.sendKeys("displayname");
//
//        WebElement day = driver.findElement(By.id("day"));
//
//        WebElement month = driver.findElement(By.id("month"));
//
//        WebElement year = driver.findElement(By.id("year"));


        nameTest("Sign Up");
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
