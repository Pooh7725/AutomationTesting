package tests;

import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EnterAccountInformationPage;
import pages.HomePage;
import pages.LoginSignupPage;
import utils.DateandTime;

import java.io.IOException;

public class RegisterUserTest extends TestBasics {
    String name = "name" + DateandTime.generateCurrentDateAndTime();
    String email = "poojasaini" + DateandTime.generateCurrentDateAndTime() + "@gmail.com";

    @Test
    public void registerUser() throws InterruptedException, IOException, ParseException {
        verifyTitle();
        verifyNewUserSignupText();
        verifyEnteredAccountInformationPageIsVisible();
        verifyThatEnterAccountInformationIsVisible();

    }

    @Step("verify title of home page")
    public void verifyTitle() {
        HomePage pg = new HomePage(driver);
        System.out.println(pg.getTitle());
        String title = "Automation Exercise";
        Assert.assertEquals(pg.getTitle(), title);

    }

    @Step("verify new user signup text")
    public void verifyNewUserSignupText() {
        String newUserSignupText = new HomePage(driver).loginSignUpClick().getNewUserSignup().getText();
        System.out.println(newUserSignupText);
        Assert.assertEquals(newUserSignupText, "New User Signup!");
    }

    @Step("verify entered account information")
    public void verifyEnteredAccountInformationPageIsVisible() throws InterruptedException {
        String VerifyAccount = new LoginSignupPage(driver).loginSignupFillDetails(name, email).getEnterAccountInformation().getText();
        System.out.println(VerifyAccount);
        Assert.assertEquals(VerifyAccount, "ENTER ACCOUNT INFORMATION");


    }

    @Step("Verify that Enter Account Information is visible")
    public void verifyThatEnterAccountInformationIsVisible() throws IOException, ParseException {
        String accountCreatedText = new EnterAccountInformationPage(driver).fillAccountDetails().getAccountCreated().getText();
        System.out.println(accountCreatedText);
        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!");


    }

}

