class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the starting point of the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Initialize pointers for both lists
        ListNode p1 = list1;
        ListNode p2 = list2;

        // Merge the two lists
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes of the non-exhausted list
        if (p1 != null) {
            current.next = p1;
        } else {
            current.next = p2;
        }

        // Return the merged list starting from the node next to the dummy
        return dummy.next;
    }
}
