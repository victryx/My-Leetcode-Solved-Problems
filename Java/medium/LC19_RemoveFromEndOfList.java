package medium;

import entities.ListNode;

public class LC19_RemoveFromEndOfList {

    public static void main(String[] args) {
        removeNthFromEnd(ListNode.of(new int[]{1,2,3,4,5 }), 2);
    }



    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. Reverse list
        ListNode prev = null;
        ListNode first = head;
        while (first != null) {
            ListNode temp = first.next;
            first.next = prev;
            prev = first;
            first = temp;
        }

        // 2. find the nth node from the start
        head = prev;
        first = prev;
        prev = null;
        ListNode next = first.next;
        int i = 1;
        while (i < n) {
            prev = first;
            first = first.next;
            next = next.next;
            i++;
        }

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        // 3. Reverse the list back
        prev = null;
        first = head;
        while (first != null) {
            ListNode temp = first.next;
            first.next = prev;
            prev = first;
            first = temp;
        }

        if (prev != null) {
            head = prev;
        }

        return head;
    }
}
