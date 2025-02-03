package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    WebDriverWait wait;
    public static void waitForElementToBeClickable(WebDriver driver, WebElement elem){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(elem));
    }
    public static void waitForElementToBeVisible(WebDriver driver , WebElement locator){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(locator));

        }

    }

