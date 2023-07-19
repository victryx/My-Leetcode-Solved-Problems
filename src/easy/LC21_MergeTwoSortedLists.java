package easy;

import entities.*;

class LC21_MergeTwoSortedLists {


    /**
     * <b>1st Try.</b> <br />
     * Iterative List Merging <br />
     * Solved: 2023-07-15
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode preHead = head;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        while(list1 != null) {
            head.next = list1;
            list1 = list1.next;
            head = head.next;
        }

        while(list2 != null) {
            head.next = list2;
            list2 = list2.next;
            head = head.next;
        }

        return preHead.next;
    }
}
