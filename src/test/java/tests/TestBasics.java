package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserManager;
import utils.PropertyLoader;

import java.io.IOException;

public class TestBasics {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        String URL = PropertyLoader.loadProperty("url");
        driver = BrowserManager.initiateDriver();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
