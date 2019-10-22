package glue_visibility.tests_steps;

import business_objects.MenuList;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import glue_visibility.utils.ResultsAnalyzer;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.BasePage;
import pages.HomePage;

public class HomePageSteps {
    private static final Logger LOGGER = Logger.getLogger(HomePageSteps.class);
    private final HomePage homePage = new HomePage();
    private BasePage newPage;

    /**
     * Page opening by URL
     */
    @Given("^Open home page$")
    public void open_home_page() {
        homePage.openHomePage();
    }

    /**
     * Clicking hamburger menu button
     */
    @When("^Click hamburger menu button$")
    public void clickHamburgerMenuButton() {
        homePage.clickHamburgerMenuButton();
    }

    /**
     * Verification of actual list to match expected hardcoded in business_objects
     */
    @Then("^Verify that all menu sections present$")
    public void checkAllMenuSectionsPresent() {
        //TODO: Move messages into Asserts - Done
//        Assert.assertEquals(expected,actual);!!!
        Assert.assertTrue("Actual menu list differs from expected!", ResultsAnalyzer.isListsEqual(homePage.getMenuList(), MenuList.getExpectedMenuList()));
    }

    //TODO: Java doc create for all methogs -
    /**
     * Clicking menu section by its name
     * @param menuSectionName - section that should be present in menu section
     */
    @When("Click \"([^\"]+)\" menu section")
    //TODO: naming methods(clickMenuSectionByName) fix - Done

    public void clickMenuSectionByName(String menuSectionName) {
        newPage = homePage.clickMenuSectionByName(menuSectionName);
    }

    /**
     * Focusing into an element "search field" and typing text in it.
     * @param searchText - symbols to be typed into an element.
     */
    @And("Type \"([^\"]+)\" in Search Field")
    //TODO: Parameters naming fix - Done
    public void typingTextInSearchField(String searchText) {
        homePage.focusSearchField();
        homePage.sendKeysToSearchField(searchText);
    }

    /**
     * Verification that page is open by URL of the page
     */
    @Then("Verify new page is open")
    public void checkURL() {
        Assert.assertTrue("Actual URL not equals Expected!",newPage.isUrlEqualsExpected());
    }

    /**
     * Verification results number in search dropdown
     * @param expectedNumberOfResults - expected number of results in search dropdown
     */
    @Then("Verify \"([^\"]+)\" results appear")
    public void checkNumberOfResults(int expectedNumberOfResults) {
        Assert.assertTrue("Actual number of results differs from expected!", ResultsAnalyzer.isNumbersEqual(homePage.getCountOfSearchResults("телефон"), null));
    }
}
