package tests;

import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;


public class RegisterUserTest extends TestBasics {
    //    String name = "name" + DateandTime.generateCurrentDateAndTime();
    String name = "anubhav123";
    //    String email = "poojasaini" + DateandTime.generateCurrentDateAndTime() + "@gmail.com";
    String email = "poojasaini@gmail.com";

    @Test
    public void registerUser() throws InterruptedException, IOException, ParseException {
        verifyTitle();
        verifyNewUserSignupText();
        verifyEnteredAccountInformationPageIsVisible();
        verifyThatEnterAccountInformationIsVisible();
        verifyThatloggedInUsernameIsVisible();
//        VerifyThatAccountDeletedOptionIsVisible();
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
    public void verifyThatEnterAccountInformationIsVisible() throws IOException, ParseException, InterruptedException {
        String accountCreatedText = new EnterAccountInformationPage(driver).fillAccountDetails().getAccountCreated().getText();
        Thread.sleep(500);
        System.out.println(accountCreatedText);
        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!");
    }

    @Step("Verify logged in username is visible")
    public void verifyThatloggedInUsernameIsVisible() {
        String username = new AccountCreatedPage(driver).continueButtonClick().getUsername().getText();
        System.out.println(username);
        Assert.assertEquals(username, "anubhav");
    }

    @Step("Verify That account deleted option is visible and click continue button")
    public void VerifyThatAccountDeletedOptionIsVisible() {
        String accountDeletedText = new LoggedHomePage(driver).deleteAccountButtonClick()
                .getAccountDeleted()
                .getText();
        System.out.println(accountDeletedText);
        Assert.assertEquals(accountDeletedText, "ACCOUNT DELETED!");
        new AccountDeletedPage(driver).continueButtonClick();

    }

}

