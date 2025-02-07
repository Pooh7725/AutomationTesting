package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DateandTime;


public class LoginUserWithIncorrectUsernameAndPassword extends TestBasics {
    @Test
    public void verifyErrorYourEmailOrPasswordIsIncorrect() {
        String email = "Poojasaini" + DateandTime.generateCurrentDateAndTime() + "@gmail.com";
        String password = DateandTime.generateCurrentDateAndTime();
        String error = new HomePage(driver).signupLoginClick().fillInCorrectDetails(email, password).getErrorLogin().getText();
        System.out.println(error);
        Assert.assertEquals(error, "Your email or password is incorrect!");
    }
}
