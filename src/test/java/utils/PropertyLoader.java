package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    public static String loadProperty(String propertyName) throws IOException {
        FileInputStream fi = new FileInputStream("src/test/Resources/config.properties");
        Properties p = new Properties();
        p.load(fi);
        return p.getProperty(propertyName);
    }
}
