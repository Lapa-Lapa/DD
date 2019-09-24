package pages;

import org.apache.log4j.Logger;

public class NewsPage implements BasePage {
    private static final Logger LOGGER = Logger.getLogger(NewsPage.class);
    private static final String URL = "https://news.tut.by/";

    public NewsPage() {
        LOGGER.info(URL + " - is open\n");
    }

    public boolean isUrlEqualsExpected() {
        LOGGER.info("Actual URL: " + driver().getCurrentUrl() + "; " +
                "Expected URL: " + URL + "\n");
        return URL.equals(driver().getCurrentUrl());
    }
}
