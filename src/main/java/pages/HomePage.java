package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import web_driver.WaitersAndUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage implements BasePage {
    private static final Logger LOGGER = Logger.getLogger(HomePage.class);
    private static final String URL = "https://www.tut.by";

    private static final By HAMBURGER_MENU_BUTTON = By.xpath("//span[@class='b-icon icon-burger']");
    private static final By MENU_SECTION = By.xpath("//ul[@class='b-topbar-more-list']");

    private static final By NEWS = By.xpath("//ul[@class='b-topbar-more-list']//a[contains(text(),'Новости')]");
    private static final By FINANCE = By.xpath("//ul[@class='b-topbar-more-list']//a[contains(text(),'Финансы')]");
    private static final By AFISHA = By.xpath("//ul[@class='b-topbar-more-list']//a[contains(text(),'Афиша')]");


    private static final By SEARCH_FIELD = By.id("search_from_str");
    private static final By SEARCH_RESULTS = By.xpath("//strong[contains(text(),'телефон')]/parent::a");

    public boolean isUrlEqualsExpected() {
        LOGGER.info("Actual URL: " + driver().getCurrentUrl() + "; " +
                "Expected URL: " + URL);
        return URL.equals(driver().getCurrentUrl());
    }

    public void openHomePage() {
        LOGGER.info(URL + " is open");
        driver().navigate().to(URL);
    }

    public void clickHamburgerMenuButton() {
        WaitersAndUtils.highlightClickUnhighlightElement(HAMBURGER_MENU_BUTTON, driver());
        LOGGER.info("Menu is open");
    }

    public List<String> getMenuList() {
        WaitersAndUtils.highlightUnhighlightElements(MENU_SECTION, driver());
        List<String> actualMenuList = new ArrayList<String>(Arrays.asList(driver().findElement(MENU_SECTION).getText().split("\n")));
        LOGGER.info("ACTUAL MENU LIST CONSIST OF " + actualMenuList.size() + " SECTIONS: " + actualMenuList.toString());
        return actualMenuList;
    }

    public BasePage clickAnyMenuSection(String MENU_SECTION_NAME) {
        if (MENU_SECTION_NAME.equals("NEWS")) {
            WaitersAndUtils.highlightClickUnhighlightElement(NEWS, driver());
            return new NewsPage();
        }
        if (MENU_SECTION_NAME.equals("FINANCE")) {
            WaitersAndUtils.highlightClickUnhighlightElement(FINANCE, driver());
            return new FinancePage();
        }
        if (MENU_SECTION_NAME.equals("AFISHA")) {
            WaitersAndUtils.highlightClickUnhighlightElement(AFISHA, driver());
            return new AfishaPage();
        } else {
            LOGGER.error(MENU_SECTION_NAME + " - is invalid Test Data");
            return new HomePage();
        }
    }

    public void focusSearchField() {
        WaitersAndUtils.highlightClickUnhighlightElement(SEARCH_FIELD, driver());
        LOGGER.info("Search field focused");
    }

    public void search(String SEARCH_TEXT) {
        WaitersAndUtils.waitForAllElementsPresent(SEARCH_FIELD, driver());
        WaitersAndUtils.waitForElementsVisible(SEARCH_FIELD, driver());
        CharSequence charSequence = SEARCH_TEXT;
        driver().findElement(SEARCH_FIELD).sendKeys(charSequence);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public int getSearchResults() {
        WaitersAndUtils.waitForAllElementsPresent(SEARCH_RESULTS, driver());
        WaitersAndUtils.waitForElementsVisible(SEARCH_RESULTS, driver());
        LOGGER.info("Appeared: " + driver().findElements(SEARCH_RESULTS).size() + " search results");
        return driver().findElements(SEARCH_RESULTS).size();
    }
}
