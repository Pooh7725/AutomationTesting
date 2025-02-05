package tests;

import org.testng.annotations.Test;
import pages.LoggedHomePage;

public class LogoutUser extends TestBasics {
    @Test
    public void VerifyThatuserIsLoggedOut() throws InterruptedException {
        LoginUserWithCorrectUsernameAndPassword.VerifyThatLoggedinUsernameIsVisible();
        Thread.sleep(5000);
        logoutUser();
        Thread.sleep(5000);
    }


    public void logoutUser() {
        String loginToYourAccountText = new LoggedHomePage(driver).logoutButtonClick().getLoginToYourAccount().getText();
        System.out.println(loginToYourAccountText);
    }
}
