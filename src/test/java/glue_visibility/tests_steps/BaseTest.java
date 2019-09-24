package glue_visibility.tests_steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import web_driver.WebDriverSingleton;

public class BaseTest {
    @Before
    public void setUp() {
        WebDriverSingleton.getWebDriverInstanceChrome();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.killWebDriver();
    }

}
