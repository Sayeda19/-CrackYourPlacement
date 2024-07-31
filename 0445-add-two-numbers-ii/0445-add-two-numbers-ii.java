import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Stacks to hold the numbers in reverse order
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        // Push all digits of l1 onto stack1
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        // Push all digits of l2 onto stack2
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        // Process stacks to add numbers
        int carry = 0;
        ListNode result = null;
        
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            carry = sum / 10;
            sum = sum % 10;
            
            // Create a new node with the sum and insert it at the beginning of the result list
            ListNode newNode = new ListNode(sum);
            newNode.next = result;
            result = newNode;
        }
        
        return result;
    }
}
