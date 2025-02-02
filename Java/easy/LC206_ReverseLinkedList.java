package easy;

import entities.ListNode;

public class LC206_ReverseLinkedList {


    /**
     * <b>1st Try.</b> <br />
     * Reverse a linked list. Iterative solution<br />
     * Solved: 2023-07-14
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
