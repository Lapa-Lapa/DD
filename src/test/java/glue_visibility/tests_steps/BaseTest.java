package glue_visibility.tests_steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import web_driver.WebDriverSingleton;

public class BaseTest {
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    @Before
    public void setUp() {
        WebDriverSingleton.getWebDriverInstanceChrome();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (!scenario.isFailed()) {
            LOGGER.info("SCENARIO PASSED -> OK!");
        } else {
            LOGGER.info("SCENARIO FAILED -> ERROR!!!");
        }
        WebDriverSingleton.killWebDriver();
    }

}
