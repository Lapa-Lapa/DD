package web_driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitersAndUtils {

    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 15;

    /**
     * ЯВНЫЕ (EXPLICIT) ОЖИДАНИЯ
     * Explicit Waits: https://seleniumjava.com/2016/04/05/the-beginners-guide-to-explicit-waits
     */
    public static void waitForElementClickable(By locator, WebDriver driver) {
        new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
    }

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
     * НЕЯВНЫЕ ИЛИ СКРЫТЫЕ(IMPLICIT) ОЖИДАНИЯ
     * Implicit Waits: https://seleniumjava.com/2015/12/12/how-to-make-selenium-webdriver-scripts-faster
     */
    public static void wait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    public static void highlightElement(By locator, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", driver.findElement(locator));
    }

    public static void unHighlightElement(By locator, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", driver.findElement(locator));
    }

    public static void highlightClickUnhighlightElement(By locator, WebDriver driver) {
        waitForElementPresent(locator, driver);
        waitForElementVisible(locator, driver);
        waitForElementClickable(locator, driver);
        highlightElement(locator, driver);
        WaitersAndUtils.wait(driver);
        driver.findElement(locator).click();
        unHighlightElement(locator, driver);
    }

    public static void highlightUnhighlightElements(By locator, WebDriver driver) {
        waitForAllElementsPresent(locator, driver);
        waitForElementsVisible(locator, driver);
        highlightElement(locator, driver);
        WaitersAndUtils.wait(driver);
        unHighlightElement(locator, driver);
    }
}
