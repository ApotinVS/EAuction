package kz.epam.EAuction.library;

/**
 * Created by Вит on 24.10.2016.
 */
public class Validator {
    private static final String PHONE_NUMBER_REGEX = "87[0-9]{9}";
    private static final String NUMBER_REGEX = "[1-9]+[0-9]*([.]?[0-9]*)";
    private static final String STRIP_HARMFUL_REGEX = "['\"\\<>]*[--]*";
    private static final String EMPTY = "";

    public static boolean isPhoneNumber(String number) {
        boolean isMatch = false;
        if (number != null) {
            isMatch = number.matches(PHONE_NUMBER_REGEX);
        }
        return isMatch;
    }

    public static boolean isNumber(String number){
        boolean isMatch = false;
        if (number != null){
            isMatch = number.matches(NUMBER_REGEX);
        }
        return isMatch;
    }

    public static String stripHarmful (String string){
        String stripted = null;
        if (string != null){
            stripted = string.replaceAll(STRIP_HARMFUL_REGEX,EMPTY);
        }
        return stripted;
    }
}
