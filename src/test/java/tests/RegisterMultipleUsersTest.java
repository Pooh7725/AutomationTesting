package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utils.TestDataProvider;

public class RegisterMultipleUsersTest extends TestBasics {

    @Test(dataProvider = "getUsers", dataProviderClass = TestDataProvider.class)
    public void registerMultipleUsers(JSONObject user) {
        System.out.println(user);
    }

    @Test(dataProvider = "getmultipleUser", dataProviderClass = TestDataProvider.class)
    public void registerMultipleusers2(JSONObject user) {
        System.out.println(user);
    }
}
