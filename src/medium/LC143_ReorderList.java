package medium;

import entities.ListNode;

import java.util.*;

public class LC143_ReorderList {

    public static void main(String[] args) {
        ListNode h = ListNode.of(new int[]{1,2,3,4,5});
        reorderList(h);
        System.out.println(h);
    }


    /**
     * <b>1st Try.</b> <br />
     * Reorder Linked List<br />
     * Solved: 2023-07-21
     */
    public static void reorderList(ListNode head) {
        List<ListNode> ls = new ArrayList<ListNode>();
        ListNode first = head;
        while (head != null) {
            ls.add(head);
            head = head.next;
        }

        int l = 0;
        int r = ls.size() - 1;
        while (l < r) {
            ls.get(l).next = ls.get(r);
            ls.get(r).next = ls.get(l + 1);

            l++;
            r--;
        }

        Set<ListNode> visited = new HashSet<>();
        while (first != null){
            if (visited.contains(first)) {
                if (ls.size() % 2 == 0) {
                    first.next = null;
                } else {
                    first.next.next = null;
                }
                return;
            }
            visited.add(first);
            first = first.next;
        }
    }

    /**
     * <b>Neetcode</b> solution <br />
     */
    public void reorderList2(ListNode head) {
        // 1. Find Mid
        ListNode s = head;
        ListNode f = head.next;
        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        // 2. Reverse List
        ListNode second = s.next;
        s.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        // Merge two halves
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
