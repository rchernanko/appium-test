import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    AppiumDriver driver;

    @Before
    public void setup()
            throws MalformedURLException {
        driver = getDriver();
    }

    @Test
    public void quickAppiumTest() {
        driver.get("http://www.bbc.co.uk/news");
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    static DesiredCapabilities getIphone6SafariCapabilities() {
        DesiredCapabilities caps = DesiredCapabilities.iphone();
        caps.setCapability("deviceName", "iPhone 6");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceOrientation", "landscape");
        caps.setCapability("platformVersion", "9.3");
        caps.setCapability("browserName", "safari");
        return caps;
    }

    static DesiredCapabilities getIpadSafariCapabilities() {
        DesiredCapabilities caps = DesiredCapabilities.iphone();
        caps.setCapability("deviceName","iPad 2");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("platformVersion","9.3");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("browserName", "Safari");
        return caps;
    }

    private AppiumDriver getDriver()
            throws MalformedURLException {

        switch (System.getProperty("browser")) {

        case "iPhone6_Safari": {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            return new IOSDriver<>(url, getIphone6SafariCapabilities());
        }
        case "iPad_Safari": {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            return new IOSDriver<>(url, getIpadSafariCapabilities());
        }
        default: {
            return null;
        }
        }
    }
}