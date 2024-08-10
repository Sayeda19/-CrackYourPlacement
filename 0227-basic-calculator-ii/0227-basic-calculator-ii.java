import java.util.*;

class Solution {
    public int calculate(String s) {
        // Remove spaces and initialize variables
        s = s.replaceAll(" ", "");
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // Check if the character is a digit and build the number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // If the character is an operator or the end of the string
            if (!Character.isDigit(ch) && ch != ' ' || i == n - 1) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }

                // Reset the number and update the operator
                num = 0;
                op = ch;
            }
        }

        // Sum up all values in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
