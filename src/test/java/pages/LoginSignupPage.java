package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.JsonReader;

import java.io.IOException;

public class LoginSignupPage {
    @FindBy(css = "button[data-qa='login-button']")
    public WebElement loginButton;
    WebDriver driver;
    @FindBy(css = "div[class='login-form'] h2")
    private WebElement loginToYourAccount;
    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;
    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;
    @FindBy(xpath = "/html/body/section/div/div/div[1]/div/form/p")
    private WebElement errorLogin;

    @FindBy(css = "div[class='signup-form'] h2")
    private WebElement newUserSignup;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupNameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmailInput;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//section/div/div/div[3]/div/form/p")
    private WebElement emailAddressAlreadyExist;

    public LoginSignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public WebElement getNewUserSignup() {
        return newUserSignup;
    }

    public EnterAccountInformationPage loginSignupFillDetails(String name, String email) {
        signupNameInput.sendKeys(name);
        signupEmailInput.sendKeys(email);
        signupButton.click();
        return new EnterAccountInformationPage(driver);
    }

    public WebElement getLoginToYourAccount() {
        return loginToYourAccount;
    }


    public LoginSignupPage fillIncorrectSignup() throws IOException, ParseException, IOException, ParseException {
        loginSignupFillDetails(JsonReader.existingUser("name"), JsonReader.existingUser("email"));
        return this;
    }


    public void fillLogin(String email, String password) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginButton.click();
    }

    public LoggedHomePage fillCorrectDetails(String email, String password) {
        fillLogin(email, password);
        return new LoggedHomePage(driver);
    }

    public LoginSignupPage fillInCorrectDetails(String email, String password) {
        fillLogin(email, password);
        return new LoginSignupPage(driver);
    }

    public WebElement getErrorLogin() {
        return errorLogin;
    }

    public WebElement getEmailAddressAlreadyExist() {
        return emailAddressAlreadyExist;
    }
}
