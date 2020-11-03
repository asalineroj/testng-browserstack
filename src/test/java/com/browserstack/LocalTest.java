package com.browserstack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        driver.get("http://localhost:45691/check");
//        iOS Testing URL for Localhost
//        driver.get("http://bs-local.com:45691/check");

        Assert.assertTrue(driver.getPageSource().contains("Up and running"));

        driver.get("http://localhost:8000/accounts/login/");
        percy.snapshot("Login");
        nameTest("Login");
        Thread.sleep(2000);
        driver.get("http://localhost:8000/polls/1/");
        percy.snapshot("Question 1");
        Thread.sleep(2000);
        driver.get("http://localhost:8000/polls/2/");
        percy.snapshot("Question 2");
        markTest("passed","Up and Running");

    }
}
