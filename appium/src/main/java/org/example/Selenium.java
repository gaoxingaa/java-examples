package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Selenium {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");
        FirefoxOptions options = new FirefoxOptions();
        Map<String, Object> dlOptions = new HashMap<>();
        dlOptions.put("userName", "admin@default.com");
        dlOptions.put("password", "Jane@123");
        dlOptions.put("tenantId", "999999999");
        dlOptions.put("region", "Europe (Frankfurt)");
        dlOptions.put("osType", "Windows Server 2022");
        dlOptions.put("browserType", "firefox");
        dlOptions.put("browserVersion", "128");
        dlOptions.put("video", "true");
        options.setCapability("digitalLab:options", dlOptions);

        URL url = new URL("http://localhost:9999/selenium/wd/hub");
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(url, options);
            System.out.println("Testing......");
            Thread.sleep(500000L);
            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"LAPTOPS\")")).click();

            System.out.println("Done.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}