import java.util.regex.*;

class Solution {
    public boolean isNumber(String s) {
        // Define a regular expression pattern for a valid number
        String pattern = "^[+-]?((\\d+\\.\\d*)|(\\.\\d+)|(\\d+))([eE][+-]?\\d+)?$";
        // Compile the pattern
        Pattern regex = Pattern.compile(pattern);
        // Match the input string with the pattern
        Matcher matcher = regex.matcher(s);
        // Return true if the string matches the pattern, false otherwise
        return matcher.matches();
    }
}
