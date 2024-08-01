import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Push element x to the back of the queue
    public void push(int x) {
        stack1.push(x);
    }
    
    // Removes the element from the front of the queue and returns it
    public int pop() {
        if (stack2.isEmpty()) {
            transferStack1ToStack2();
        }
        return stack2.pop();
    }
    
    // Get the front element
    public int peek() {
        if (stack2.isEmpty()) {
            transferStack1ToStack2();
        }
        return stack2.peek();
    }
    
    // Returns whether the queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    // Transfer elements from stack1 to stack2
    private void transferStack1ToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
