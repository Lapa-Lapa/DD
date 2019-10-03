package pages;

import org.apache.log4j.Logger;

public class AfishaPage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(AfishaPage.class);
    private static final String URL = "https://afisha.tut.by/";

    public AfishaPage() {
        LOGGER.info(URL + " - is open");
    }

    @Override
    public String getURL() {
        return URL;
    }
}
