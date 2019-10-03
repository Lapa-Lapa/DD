package pages;

import org.apache.log4j.Logger;

public class FinancePage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(FinancePage.class);
    private static final String URL = "http://finance.tut.by/";

    public FinancePage() {
        LOGGER.info(URL + " - is open");
    }

    @Override
    public String getURL() {
        return URL;
    }
}
