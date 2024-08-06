import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;
        
        while (index < heights.length) {
            // If the stack is empty or the current bar is higher than the bar at stack top, push it.
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index++);
            } else {
                // Pop the top height from stack and calculate area with it as the smallest (or minimum height) bar 'h'
                int topOfStack = stack.pop();
                // Calculate the area with heights[topOfStack] as the smallest (or minimum height) bar
                int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                // Update maxArea, if needed
                maxArea = Math.max(maxArea, area);
            }
        }
        
        // Now, pop the remaining bars from stack and calculate area
        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = heights[topOfStack] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
