package pages;

import org.apache.log4j.Logger;

public class AfishaPage implements BasePage {
    private static final Logger LOGGER = Logger.getLogger(AfishaPage.class);
    private static final String URL = "https://afisha.tut.by";

    public AfishaPage() {
        LOGGER.info(URL + " - is open");
    }

    public boolean isUrlEqualsExpected() {
        LOGGER.info("Actual URL: " + driver().getCurrentUrl() + "; " +
                "Expected URL: " + URL);
        return URL.equals(driver().getCurrentUrl());
    }
}
