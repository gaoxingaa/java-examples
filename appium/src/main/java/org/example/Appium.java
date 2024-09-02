package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Set the desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browserName", "Chrome");


//        caps.setCapability("uftm:oauthClientId", "oauth2-3qNug2F27gFKcum6VAN9@microfocus.com");
//        caps.setCapability("uftm:oauthClientSecret", "fRa0gSItx6r6KU3Pu0UM");
        caps.setCapability("uftm:userName", "admin@default.com");
        caps.setCapability("uftm:password", "Jane@123");

//        caps.setCapability("uftm:password", "1Qazxsw2");
        caps.setCapability("uftm:tenantId", "999999999");
        caps.setCapability("appium:udid", "b4715d3b");
        caps.setCapability("appium:appPackage", "com.Advantage.aShopping");
        caps.setCapability("appium:appActivity", "com.Advantage.aShopping.SplashActivity");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "MI 8 UD");
        caps.setCapability("dl:video", true);


        for (int i = 0; i < 300; i++) {
            System.out.println("Try times " + i);
            AppiumDriver driver = null;
            try {
                // Initialize the driver
                driver = new AndroidDriver(new URL("http://127.0.0.1:9999/wd/hub"), caps);
//                driver = new AndroidDriver(new URL("http://10.241.10.10:8080/wd/hub"), caps);

                // Click
                Thread.sleep(5000);

                driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"LAPTOPS\")")).click();
                driver.findElement(By.id("imageViewFilter")).click();
                driver.findElement(By.id("textViewCancel")).click();
                Thread.sleep(5000);

                //Location location = driver.Driver.Location;
                driver.findElement(By.id("imageViewMenu")).click();
                driver.findElement(By.id("textViewMenuLaptops")).click();
                driver.findElement(By.id("imageViewFilter")).click();
//        driver.findElements(By.id("textViewFilterCategoryTitle")).get(0).click();
//
//        var colors = driver.findElements(By.className( "android.view.View"));
//        int count = colors.Count();
//        colors.ElementAt(count - 4)).click();
//
//        var ischecked = driver.findElement(By.id( "imageViewFilterCategoryCheched");
//        ClassicAssert.IsTrue(ischecked != null, "checked element could not be found and equals to NULL when using findElement by 'imageViewFilterCategoryCheched' string as a id!");
//
//        driver.findElement(By.id( "textViewApply")).click();
//        driver.findElement(By.id( "RelativeLayoutProductControl")).click();
//        driver.findElement(By.id( "buttonProductAddToCart")).click();
//        string XPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText";
//        var username = driver.findElement(Locators.ByXPath, XPath);
//        username.SendKeys("test");
//        String XPathpassword = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText";
//        var password = driver.findElement(Locators.ByXPath, XPathpassword);
//        password.SendKeys("test");
//        driver.findElement(By.id( "com.Advantage.aShopping:id/buttonLogin")).click();
//        try
//        {
//            ClassicAssert.IsNotEmpty(driver.findElementIfExist(By.id( "com.Advantage.aShopping:id/textViewFailed").Text, "Incorrect user name or password.");
//        }
//        catch
//        { }
//        driver.KillAppliactionForAndroid("com.Advantage.aShopping");
//        //Location location = driver.Driver.Location;
//
//        driver
                // Quit the driver
            } catch (Exception e) {
                System.err.println("Error, try again");
            } finally {
                if (driver != null) {
                    driver.quit();
                }
                Thread.sleep(5000);
            }

        }
    }

}
