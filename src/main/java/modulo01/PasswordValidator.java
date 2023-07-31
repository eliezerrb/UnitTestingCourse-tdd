package modulo01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private static final int MINIMUM_LENGTH_PASSWORD = 8;

    private static final int MAXIMUM_LENGTH_PASSWORD = 30;

    public static boolean hasTheMinimumNumberCharacters(String password) {
        return password.length() >= MINIMUM_LENGTH_PASSWORD;
    }

    public static boolean hasTheMaximumNumberCharacters(String password) {
        return password.length() < MAXIMUM_LENGTH_PASSWORD;
    }

    public static boolean passwordHasNumbers(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean passwordContainsBirthdate(String password, LocalDate birthdate) {
        DateTimeFormatter formatterBr = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formattedBirthdate = birthdate.format(formatterBr);
        Pattern pattern = Pattern.compile(".*" + formattedBirthdate + ".*");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
