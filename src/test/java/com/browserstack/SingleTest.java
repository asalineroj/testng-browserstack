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
        driver.get("https://open.spotify.com/");
        percy.snapshot("Home Page");
        Thread.sleep(2000);
//        WebElement element = driver.findElement(By.tagName("SIGN UP"));
//        element.click();
//        Thread.sleep(5000);
//        By.cssSelector("div.wrap>div>header>div>nav>ul>li>a[href='https://www.spotify.com/ie/signup/']")
//        WebElement element = driver.findElement(By.xpath("//a[@ref='https://www.spotify.com/ie/signup/']"));
//        element.click();
        driver.get("https://www.spotify.com/ie/signup/");
        percy.snapshot("Sign Up Page");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("andres@browserstack.com");
        WebElement confirm = driver.findElement(By.id("confirm"));
        confirm.sendKeys("andres@browserstack.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");
        WebElement displayname = driver.findElement(By.id("displayname"));
        displayname.sendKeys("displayname");

        WebElement day = driver.findElement(By.id("day"));

        WebElement month = driver.findElement(By.id("month"));

        WebElement year = driver.findElement(By.id("year"));

        WebElement gender = driver.findElement(By.id("gender"));

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
