package utils;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class TestDataProvider {

    @DataProvider(name = "getUsers")
    public static Object[][] getUsers() throws IOException, ParseException {
        JSONArray users = JsonReader.sampleUsers();
        Object[][] data = new Object[users.size()][1];
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i); // Store each JSON object in test data
        }
        return data;

    }

    @DataProvider(name = "getmultipleUser")
    public static Object[][] getmultipleUser() throws IOException, ParseException {
        JSONArray multipleuser = JsonReader.sampleUser2();
        Object[][] dataOfMultipleUsers = new Object[multipleuser.size()][1];
        for (int i = 0; i < multipleuser.size(); i++) {
            dataOfMultipleUsers[i][0] = multipleuser.get(i);
        }
        return dataOfMultipleUsers;
    }
}
