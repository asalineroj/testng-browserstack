package com.browserstack;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.browserstack.local.Local;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.percy.selenium.Percy;


public class BrowserStackTestNGTest {
    public WebDriver driver;
    private Local l;
    protected String sessionID;
    private String username;
    private String accessKey;
    private String build;
    private String project;
    protected String percyProfile;
    protected Percy percy;

    @BeforeMethod(alwaysRun = true)
    @org.testng.annotations.Parameters(value = { "config", "environment" })
    @SuppressWarnings("unchecked")
    public void setUp(String config_file, String environment) throws Exception {
        percyProfile = System.getenv("PERCY_ENABLE");
        System.out.println("percy enabled?  "+percyProfile);
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
        JSONObject envs = (JSONObject) config.get("environments");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (capabilities.getCapability(pair.getKey().toString()) == null) {
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }

        username = System.getenv("BROWSERSTACK_USERNAME");
        if (username == null) {
            username = (String) config.get("user");
        }

        accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if (accessKey == null) {
            accessKey = (String) config.get("key");
        }

        build = System.getenv("BROWSERSTACK_BUILD_NAME");
        project = System.getenv("BROWSERSTACK_PROJECT");
        if (build!=null) {
            capabilities.setCapability("build", build);
        }
        if (project!=null) {
            capabilities.setCapability("project", project);
        }
        if (capabilities.getCapability("browserstack.local") != null
                && capabilities.getCapability("browserstack.local") == "true") {
            Map<String, String> options = new HashMap<String, String>();
            options.put("key", accessKey);
//            Local connection established via CLI
//            l = new Local();
//            l.start(options);
        }
        System.out.print(capabilities);
        driver = new RemoteWebDriver(
                new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), capabilities);
        percy = new Percy(driver);
        sessionID = ((RemoteWebDriver) driver).getSessionId().toString();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {

        driver.quit();
        if (l != null) {
            l.stop();
        }
    }

    protected void nameTest(String sessionName) throws IOException, URISyntaxException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\":\""+sessionName+"\" }}");
    }

    protected void markTest(String passed, String reason) throws IOException, URISyntaxException {
//        URI uri = new URI("https://"+username+":"+accessKey+"@api.browserstack.com/automate/sessions/"+sessionID+".json");
//        HttpPut putRequest = new HttpPut(uri);
//
//        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//        nameValuePairs.add((new BasicNameValuePair("status", passed)));
//        nameValuePairs.add((new BasicNameValuePair("reason", reason)));
//        putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//        HttpClientBuilder.create().build().execute(putRequest);


        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String executeScript = "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \""+reason+"\"}}";
        System.out.println(executeScript);
        jse.executeScript(executeScript);
    }
}
