import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.*;
import org.aspectj.lang.annotation.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;


/**
 * Test -android uiautomator locator strategy
 */
public class TestApp {

    private AndroidDriver driver;

    @Before
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability("appPackage", "com.hiqo_solutions.screenshotservice");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @Test
    public void openApp(){

        driver.findElementByAndroidUIAutomator("new UiSelector().resourse-id(\"com.google.android.apps.nexuslauncher:id/all_apps_handle\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"CutIT\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Open navigation drawer\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Settings\")").click();

        String URLDefault = driver.findElementByAndroidUIAutomator("new UiSelector().resourse-id(\"android:id/switch_widget\")").getText();
        System.out.println(URLDefault);

    }
}



