package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginUserWithCorrectUsernameAndPassword extends TestBasics {
    @Test

    public void VerifyThatLoggedinUsernameIsVisible() {
        String email = "poojasaini@gmail.com";
        String password = "harry124";
        String username = new HomePage(driver).loginSignUpClick().fillCorrectDetails(email, password).getUsername().getText();
        System.out.println(username);
        Assert.assertEquals(username, "anubhav123");
    }
}
