package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager {
    public static WebDriver initiateDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/pooja/Downloads/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
