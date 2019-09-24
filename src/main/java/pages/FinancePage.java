package pages;

import org.apache.log4j.Logger;

public class FinancePage implements BasePage {
    private static final Logger LOGGER = Logger.getLogger(FinancePage.class);
    private static final String URL = "https://finance.tut.by/";

    public FinancePage() {
        LOGGER.info(URL + " - is open\n");
    }

    public boolean isUrlEqualsExpected() {
        LOGGER.info("Actual URL: " + driver().getCurrentUrl() + "; " +
                "Expected URL: " + URL + "\n");
        return URL.equals(driver().getCurrentUrl());
    }
}
