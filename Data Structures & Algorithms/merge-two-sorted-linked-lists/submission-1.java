class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. Create a dummy node to act as the start of the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // 2. Traverse both lists with the two pointers
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // 3. Attach any remaining nodes from either list
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }
        
        // Return the actual head of the new list, skipping the temporary dummy node
        return dummy.next;
    }
}