class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Edge case: if the list is empty or has only one element, return it as is
        if (head == null) {
            return head;
        }

        ListNode current = head;

        // Traverse the linked list
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the duplicate node
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        return head;
    }
}
