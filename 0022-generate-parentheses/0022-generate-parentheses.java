import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, "", 0, 0, n);
        return result;
    }
    
    private void generateParenthesisHelper(List<String> result, String current, int open, int close, int max) {
        // Base case: If the current string is of the maximum length, add to result
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        // Add an open parenthesis if we haven't used all of them
        if (open < max) {
            generateParenthesisHelper(result, current + "(", open + 1, close, max);
        }
        
        // Add a close parenthesis if it doesn't exceed the number of open ones
        if (close < open) {
            generateParenthesisHelper(result, current + ")", open, close + 1, max);
        }
    }
}
