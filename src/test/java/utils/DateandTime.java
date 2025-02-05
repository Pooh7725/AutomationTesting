package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateandTime {
    public static String generateCurrentDateAndTime() {
        return new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
    }
}
