import java.util.*;

class Solution {
    public String reverseWords(String s) {
        // Trim the string to remove leading/trailing spaces
        s = s.trim();
        
        // Split the string by whitespace and get words
        String[] words = s.split("\\s+");
        
        // Reverse the array of words
        Collections.reverse(Arrays.asList(words));
        
        // Join words with a single space
        return String.join(" ", words);
    }
}
