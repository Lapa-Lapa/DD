package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.Exceptions.TestDataException;
import web_driver.WaitersAndUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(HomePage.class);
    private static final String URL = "https://www.tut.by";

    private static final By HAMBURGER_MENU_BUTTON = By.xpath("//span[contains(@class,'b-icon icon-burger')]");
    //TODO: space - bad better &
    private static final By MENU_SECTION = By.xpath("//ul[contains(@class,'b-topbar-more-list')]");
    //TODO: One dymanic locator - see menuSectionNameLocatorFactory - Done
    private static final By SEARCH_FIELD = By.id("search_from_str");
    //TODO: Locator for SEARCH_RESULTS not case sensitive and word dependent - see searchResultsLocatorFactory - Done

    private static By menuSectionNameLocatorFactory(String sectionName) {
        //TODO: Better to write contains(@class,'smth') - should be more stable - Done
        return By.xpath("//ul[contains(@class,'b-topbar-more-list')]//a[contains(text(),'" + sectionName + "')]");
    }

    private static By searchResultsLocatorFactory(String sectionName) {
        return By.xpath("//strong[contains(text(),'" + sectionName.toLowerCase() + "')]/parent::a");
        //Todo: регистронезависимый!!!
    }

    @Override
    public String getURL() {
        return URL;
    }

    public void openHomePage() {
        LOGGER.info(URL + " is open");
        driver().navigate().to(URL);
    }

    public void clickHamburgerMenuButton() {
        WaitersAndUtils.highlightAndClickElement(HAMBURGER_MENU_BUTTON, driver());
        LOGGER.info("Menu is open");
    }

    public List<String> getMenuList() {
        WaitersAndUtils.highlighElements(MENU_SECTION, driver());
        WaitersAndUtils.unHighlighElements(MENU_SECTION, driver());
        return new ArrayList<String>(Arrays.asList(driver().findElement(MENU_SECTION).getText().split("\n")));
    }

    /**
     * TODO:
     * @param menuSectionName
     * @return
     */
    public BasePage clickMenuSectionByName(String menuSectionName) {
        //TODO: (if(x){}else{}-->switch(x){case"y":...default:}) - Done
        switch (menuSectionName) {
            case "NEWS":
                WaitersAndUtils.highlightAndClickElement(menuSectionNameLocatorFactory("Новости"), driver());
                return new NewsPage();
            case "FINANCE":
                WaitersAndUtils.highlightAndClickElement(menuSectionNameLocatorFactory("Финансы"), driver());
                return new FinancePage();
            case "AFISHA":
                WaitersAndUtils.highlightAndClickElement(menuSectionNameLocatorFactory("Афиша"), driver());
                return new AfishaPage();
            default:
                //TODO: (RuntimeException-->Beautiful custom exception) - Done
                //TODO:enum - Testdata exception
                throw new TestDataException("ERROR! - " + menuSectionName + "Is not supported. Following supported:"/**enum*/);
        }
    }

    public void focusSearchField() {
        WaitersAndUtils.highlightAndClickElement(SEARCH_FIELD, driver());
        LOGGER.info("Search field focused");
    }

    public String sendKeysToSearchField(String searchText) {
        CharSequence charSequence = searchText;
        driver().findElement(SEARCH_FIELD).sendKeys(charSequence);
        LOGGER.info("Searching for text: " + searchText);
        //TODO: Debug more, remove Thread.sleep - Done
        return searchText;
    }

    public int getCountOfSearchResults(String searchText) {
        WaitersAndUtils.waitForElementsVisible(searchResultsLocatorFactory(searchText), driver());
        LOGGER.info("Appeared: " + driver().findElements(searchResultsLocatorFactory(searchText)).size() + " search results");
        return driver().findElements(searchResultsLocatorFactory(searchText)).size();
    }
}
