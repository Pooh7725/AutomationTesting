package tests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class RegisterUserWithExistingEmail extends TestBasics {
    //    @Description("""
//            1. Launch browser
//            2. Navigate to url 'http://automationexercise.com'
//            3. Verify that home page is visible successfully
//            4. Click on 'Signup / Login' button
//            5. Verify 'New User Signup!' is visible
//            6. Enter name and already registered email address
//            7. Click 'Signup' button
//            8. Verify error 'Email Address already exist!' is visible""")
    @Test
    public void verifyErrorUserAlreadyExist() throws IOException, ParseException {
        RegisterUserTest.verifyTitle();
//        String newUserSignupText = new LoginSignupPage(driver).getNewUserSignup().getText();
        String errorEmailAddressAlreadyExist = new HomePage(driver).loginSignUpClick().fillIncorrectSignup().getEmailAddressAlreadyExist().getText();
        System.out.println(errorEmailAddressAlreadyExist);
    }
}
