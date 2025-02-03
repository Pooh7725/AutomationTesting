package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignupPage {
    WebDriver driver;

    @FindBy(css = "div[class='login-form'] h2")
    private WebElement loginToYourAccount;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

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

}
