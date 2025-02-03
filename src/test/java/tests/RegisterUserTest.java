package tests;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginSignupPage;

public class RegisterUserTest extends TestBasics {
    @Test
    public void registerUser() throws InterruptedException {
        verifyTitle();
        verifyNewUserSignupText();
        verifyEnteredAccountInformation();

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
    public void verifyEnteredAccountInformation() throws InterruptedException {
        String name = "pooja";
        String email = "pooja.saini@gmail.com";
        String VerifyAccount = new LoginSignupPage(driver).loginSignupFillDetails(name, email).getEnterAccountInformation().getText();
        System.out.println(VerifyAccount);
        Assert.assertEquals(VerifyAccount, "ENTER ACCOUNT INFORMATION");


    }


}

