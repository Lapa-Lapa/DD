package pages;

import org.openqa.selenium.WebDriver;
import web_driver.WebDriverSingleton;

public interface BasePage {

    default WebDriver driver() {
        return WebDriverSingleton.getWebDriverInstanceChrome();
    }

    boolean isUrlEqualsExpected();
}
