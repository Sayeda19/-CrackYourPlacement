class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node which points to the head of the list
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Initialize the current node as the dummy node
        ListNode current = dummy;

        // Traverse the list
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                // Skip the node with the value to be removed
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        // Return the updated list, starting from the node after the dummy
        return dummy.next;
    }
}
