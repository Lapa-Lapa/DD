package pages;

import org.apache.log4j.Logger;

public class NewsPage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(NewsPage.class);
    private static final String URL = "https://news.tut.by/";

    public NewsPage() {
        LOGGER.info(URL + " - is open");
    }

    @Override
    public String getURL() {
        return URL;
    }
}
