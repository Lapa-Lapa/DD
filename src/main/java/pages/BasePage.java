package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web_driver.WebDriverSingleton;

//TODO: BasePage hould be Abstract Class!!! - Done
public abstract class BasePage {
    private static final Logger LOGGER = Logger.getLogger(BasePage.class);

    public abstract String getURL();

    static WebDriver driver() {
        return WebDriverSingleton.getWebDriverInstanceChrome();
    }

    public boolean isUrlEqualsExpected() {
        LOGGER.info("Actual URL: " + driver().getCurrentUrl() + "; " +
                "Expected URL: " + getURL());
        return getURL().equals(driver().getCurrentUrl());
    }
}
