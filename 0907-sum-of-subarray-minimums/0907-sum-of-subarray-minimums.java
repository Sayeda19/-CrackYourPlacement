import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1000000007;
        
        // Arrays to store the distance to previous less element and next less element
        int[] ple = new int[n];
        int[] nle = new int[n];
        
        // Stack to find previous less element
        Stack<Integer> stack = new Stack<>();
        
        // Compute PLE (Previous Less Element)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ple[i] = (stack.isEmpty() ? i + 1 : i - stack.peek());
            stack.push(i);
        }
        
        // Clear the stack for next usage
        stack.clear();
        
        // Compute NLE (Next Less Element)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nle[i] = (stack.isEmpty() ? n - i : stack.peek() - i);
            stack.push(i);
        }
        
        // Calculate the result
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * ple[i] * nle[i]) % mod;
        }
        
        return (int) result;
    }
}
