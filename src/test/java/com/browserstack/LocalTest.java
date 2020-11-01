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
        markTest("passed","Up and Running");
        driver.get("http://localhost:8000/accounts/login/");

    }
}
