package utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static String accountDetails(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fi = new FileReader("src/test/resources/testData/accountDetails.json");
        Object obj = jsonParser.parse(fi);
        JSONObject accountDetailsObj = (JSONObject) obj;
        return (String) accountDetailsObj.get(data);
    }

    public static String existingUser(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/resources/testData/existingUserDetails");
        Object obj = jsonParser.parse(fileReader);
        JSONObject existingUser = (JSONObject) obj;
        return (String) existingUser.get(data);
    }
}



