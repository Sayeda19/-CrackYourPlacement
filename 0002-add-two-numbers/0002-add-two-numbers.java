class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify the result list handling
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        
        // Traverse both lists until both are null
        while (l1 != null || l2 != null) {
            // Get the current values from both nodes, if available
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            // Calculate the sum of the two digits plus carry
            int sum = val1 + val2 + carry;
            
            // Update carry for next iteration
            carry = sum / 10;
            
            // Create a new node with the value of sum % 10 and move the pointer
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            // Move to the next nodes in the lists, if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // If there's any carry left after the final addition, add a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        // Return the result list starting from the node after the dummy head
        return dummyHead.next;
    }
}
