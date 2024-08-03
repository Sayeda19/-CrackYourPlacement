import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            result.append(String.valueOf(pair.ch).repeat(pair.count));
        }
        
        return result.reverse().toString();
    }
    
    class Pair {
        char ch;
        int count;
        
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
