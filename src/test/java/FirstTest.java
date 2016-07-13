import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    IOSDriver driver;

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

    static DesiredCapabilities getIosCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "iPhone 6");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "9.3");
        caps.setCapability("browserName", "safari");
        return caps;
    }

    private IOSDriver getDriver()
            throws MalformedURLException {

        switch (System.getProperty("browser")) {

        case "appium": {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            return new IOSDriver<>(url, getIosCapabilities());
        }
        default: {
            return null;
        }
        }
    }
}