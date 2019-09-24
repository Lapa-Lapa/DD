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

import java.util.List;

public class HomePageSteps {
    private static final Logger LOGGER = Logger.getLogger(HomePageSteps.class);
    private final HomePage homePage = new HomePage();
    private BasePage newPage;

    @Given("^Open home page$")
    public void open_home_page() {
        homePage.openHomePage();
    }

    @When("^Click hamburger menu button$")
    public void clickHamburgerMenuButton() {
        homePage.clickHamburgerMenuButton();
    }

    @Then("^Verify that all menu sections present$")
    public void check() {
        List<String> expectedMenuList = MenuList.getExpectedMenuList();
        LOGGER.info("EXPECTED MENU LIST CONSIST OF " + expectedMenuList.size() + " SECTIONS: " + expectedMenuList.toString());
        Assert.assertTrue(ResultsAnalyzer.isListsEqual(homePage.getMenuList(), expectedMenuList));
    }

    @When("Click \"([^\"]+)\" menu section")
    public void clickAnyMenuSection(String MENU_SECTION_NAME) {
        newPage = homePage.clickAnyMenuSection(MENU_SECTION_NAME);
    }

    @And("Search for \"([^\"]+)\"")
    public void search(String SEARCH_TEXT) {
        homePage.focusSearchField();
        homePage.search(SEARCH_TEXT);
    }

    @Then("Verify new page is open")
    public void checkURL() {
        newPage.isUrlEqualsExpected();
    }

    @Then("Verify \"([^\"]+)\" results appear")
    public void checkNumberOfResults(int NUMBER_OF_RESULTS) {
        Assert.assertEquals(NUMBER_OF_RESULTS, homePage.getSearchResults());
    }
}
