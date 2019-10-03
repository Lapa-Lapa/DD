package web_driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class WaitersAndUtils {

    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 15;

    /**
     * ЯВНЫЕ (EXPLICIT) ОЖИДАНИЯ Explicit Waits: https://seleniumjava.com/2016/04/05/the-beginners-guide-to-explicit-waits
     */
    public static void waitForElementClickable(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waiting for element to be present in DOM
     * @param locator - used here because WebElement can not be used because of presenceOfElementLocated could be used
     *                only with locator element.
     * @param driver  - selenium web driver
     */
    public static void waitForElementPresent(By locator, WebDriver driver) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForAllElementsPresent(By locator, WebDriver driver) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static void waitForElementVisible(By locator, WebDriver driver) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementsVisible(By locator, WebDriver driver) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void checkUrlToBe(String URL, WebDriver driver) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.urlToBe(URL));
    }

    /**
     * НЕЯВНЫЕ ИЛИ СКРЫТЫЕ(IMPLICIT) ОЖИДАНИЯ Implicit Waits: https://seleniumjava.com/2015/12/12/how-to-make-selenium-webdriver-scripts-faster
     */
    public static void wait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //TODO: Make 1 more generalized method - Done
    public static void highlightElement(WebElement element, WebDriver driver, boolean highlight) {
        String styleBorder;
        if (highlight) {
            styleBorder = "'3px solid green'";
        } else {
            styleBorder = "'0px'";
        }
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.border=" + styleBorder, element);
    }

    public static WebElement findElement(By locator, WebDriver driver) {
        return driver.findElement(locator);
    }

    public static void highlightAndClickElement(By locator, WebDriver driver) {
        //TODO: Optimize use one time found element - Done
        WebElement element = findElement(locator, driver);
        waitForElementClickable(element, driver);
        highlightElement(element, driver, TRUE);
        element.click();
    }

    public static void highlighElements(By locator, WebDriver driver) {
        WebElement element = findElement(locator, driver);
        waitForElementsVisible(locator, driver);
        highlightElement(element, driver, TRUE);
        WaitersAndUtils.wait(driver);
        highlightElement(element, driver, FALSE);
    }
}
