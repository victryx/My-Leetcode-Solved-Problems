package easy;

import entities.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LC141_LinkedListCycle {

    /**
     * <b>1st Try.</b> <br />
     * Reverse a linked list. Iterative solution<br />
     * Solved: 2023-07-19
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            set.add(head);
            head = head.next;
            if (set.contains(head)) {
                return true;
            }
        }
        return false;
    }
}
