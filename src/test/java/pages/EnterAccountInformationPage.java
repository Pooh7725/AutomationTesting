package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.DateandTime;
import utils.JsonReader;

import java.io.IOException;

public class EnterAccountInformationPage {

    @FindBy(xpath = "//b[contains(.,'Enter Account Information')]")
    private WebElement enterAccountInformation;

    @FindBy(id = "id_gender1")
    private WebElement titleMrCheckbox;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysSelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    private WebDriver driver;

    public EnterAccountInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getEnterAccountInformation() {
        return enterAccountInformation;
    }

    public AccountCreatedPage fillAccountDetails() throws IOException, ParseException {
        String Password = DateandTime.generateCurrentDateAndTime();
        titleMrCheckbox.click();
        passwordInput.sendKeys(Password);
        Select days = new Select(daysSelect);
        days.selectByValue(JsonReader.accountDetails("day"));
        Select months = new Select(monthsSelect);
        months.selectByValue(JsonReader.accountDetails("month"));
        Select years = new Select(yearsSelect);
        years.selectByValue(JsonReader.accountDetails("year"));
        scrollIntoView(newsletterCheckbox).click();
        specialOffersCheckbox.click();
        firstNameInput.sendKeys(JsonReader.accountDetails("firstname"));
        lastNameInput.sendKeys(JsonReader.accountDetails("lastname"));
        companyInput.sendKeys(JsonReader.accountDetails("company"));
        address1Input.sendKeys(JsonReader.accountDetails("address1"));
        address2Input.sendKeys(JsonReader.accountDetails("address2"));
        Select countrySelector = new Select(scrollIntoView(countrySelect));
        countrySelector.selectByValue(JsonReader.accountDetails("country"));
        stateInput.sendKeys(JsonReader.accountDetails("state"));
        cityInput.sendKeys(JsonReader.accountDetails("city"));
        zipcodeInput.sendKeys(JsonReader.accountDetails("zipcode"));
        mobileNumberInput.sendKeys(JsonReader.accountDetails("mobilenumber"));
        createAccountButton.click();
        return new AccountCreatedPage(driver);
    }

    private WebElement scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }
}
