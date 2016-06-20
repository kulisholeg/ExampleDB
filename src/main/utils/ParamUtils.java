package utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public  class ParamUtils {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static String stringNormalize(String string) {
        return string.trim();
    }


    public static Date parseStringToDate(String dateString) {
        try {
            return SIMPLE_DATE_FORMAT.parse(dateString);
        } catch (Exception ignored) {
        }
        return null;
    }


    public static String parseDateToString(Date date) {
        try {
            return SIMPLE_DATE_FORMAT.format(date);
        } catch (Exception ignored) {
        }
        return null;
    }


    public static Integer getInt(String stringInt) {
        try {
            return Integer.parseInt(stringInt);
        } catch (Exception ignored) {
        }
        return null;
    }


}
