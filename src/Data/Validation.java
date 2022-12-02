// Validation class
package ryomainternational;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HP
 */
public final class Validation {

    private Validation() {
//RegEx Classes for matching character sequences against patterns specified by regular expressions
//pattern is a compiled representation of a regular expression
//Pattern.compile = compile the given regular expression into a pattern with the given flags
//matcher class..
//matcher is an engine that performs match operations on a character sequence by interpreting a Pattern.
//A matcher is created from a pattern by invoking the pattern's matcher method. Once created,--
        //--a matcher can be used to perform three different kinds of match operations:
        //--matches : method attempts to match the entire input sequence against the pattern..
        //--lookingAt : method attempts to match the input sequence, starting at the beginning, against the pattern...
        //--find : method scans the input sequence looking for the next subsequence that matches the pattern...
    }

    public static boolean validateAddress(String text) {
        String regex = "^[0-9A-Za-z]+[0-9A-Za-z' .,/\\\\]+$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        //creating a matcher using the compiled pattern..
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateDate(String text) { //OK
        String regx = "^[0-9]{1,2}$"; //max = 30 min = 01
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            int days = Integer.parseInt(text);
            return (days < 31);
        } else {
            return false;
        }
    }

    public static boolean validateDouble(String text) { //OK
        String regx = "^[0-9]+[.]?[0-9]*$"; //Max = infinity Min = 0
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateIdentityNo(String text) { //OK
        String regx = "^[0-9]{2}[0-8][0-9]{6}[V]$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateInteger(String text) { //OK
        String regx = "^[1-9][0-9]*$"; //max = infinity min = 1
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateIntegerUpdate(String text) { //OK
        String regx = "^[0-9][0-9]*$"; //max = infinity min = 1
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateMonth(String text) { //OK
        String regx = "^[0-9]{1,2}$"; //max = 11 min = 01
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            int months = Integer.parseInt(text);
            return (months < 12);
        } else {
            return false;
        }
    }

    public static boolean validatePrice(String text) { //OK
        String regx = "^[1-9][0-9]{0,15}[.]?[0-9]{0,2}$"; //Max = 99999.99 Min = 1
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateString(String text) { //OK
        String regx = "^[a-zA-Z][a-zA-Z. ]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateStringTestResults(String text) { //OK
        String regx = "^[0-9a-zA-Z][0-9a-zA-Z -]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateStringTestResultsWithDot(String text) { //OK
        String regx = "^[0-9a-zA-Z][0-9a-zA-Z. -]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateStringWithOutDot(String text) { //OK
        String regx = "^[a-zA-Z ]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateTelephoneNumber(String text) { //OK
        String regx = "^[0][1-9]{2}[0-9]{7}$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateTest(String text) { //OK
        String regx = "^[0-9a-zA-Z -]+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateUnit(String text) { //OK
        if (text.isEmpty()) {
            return false;
        }
        String regx = "[`!@#$^&|\\\\{}~;:',?><=+-]+";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return !matcher.find();
    }

    public static boolean validateYear(String text) { //OK
        String regx = "^[1-9][0-9]{3,3}$"; //max = 999 min = 1
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
}
