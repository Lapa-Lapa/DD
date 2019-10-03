package web_driver;

import cucumber.api.java.After;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Exceptions.InvalidUrlForAppiumDriver;
import utils.Exceptions.WebDriverInstantiationException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static final Logger LOGGER = Logger.getLogger(WebDriverSingleton.class);
    private static WebDriver instance;
    private static final int DEFAULT_TIMEOUT = 15;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstanceChrome() {
        if (instance != null) {
            return instance;
        }
        return instance = initWebDriver();
    }

    /**
     * Static Factory Method https://cucumber.io/docs/guides/browser-automation
     */
    private static WebDriver initWebDriver() {
        String browserName = System.getProperty("browser");
        String platformVersion = System.getProperty("platformVersion");
        String UDID = System.getProperty("UDID");
        WebDriver driver;
        switch (browserName) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "android":
                //TODO:Make one method for Android
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, UDID);
                desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
                desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                try {
                    //TODO: (MalformedURLException(CheckedException)-->From Automatic to custom-->InvalidUrlForAppiumDriverv) - Done
                    URL url = new URL("http://0.0.0.0:4723/wd/hub");
                    driver = new AppiumDriver<MobileElement>(url, desiredCapabilities);
                    break;
                } catch (MalformedURLException exception) {
                    exception.printStackTrace();
                    throw new InvalidUrlForAppiumDriver("ERROR! [" + exception.getMessage() + "]");
                }
            default:
                //TODO: (RuntimeException-->Beautiful custom exception) - Done
                throw new WebDriverInstantiationException("ERROR! [" + browserName + "] - is invalid or unsupported name for browser.");
        }
        LOGGER.info("Browser: " + browserName + " - successfully started");
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);//IMPLICIT
        driver.manage().timeouts().setScriptTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);//IMPLICIT
        LOGGER.info("PageLoadTimeout was set to: " + DEFAULT_TIMEOUT + " seconds");
        return driver;
    }

    @After
    public static void killWebDriver() {
        if (instance != null) {
            try {
                instance.quit();
            } catch (Exception e) {
                LOGGER.error("Kill Web Driver error");
            } finally {
                instance = null;
            }
        }
    }
}
