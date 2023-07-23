package entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode head = this;
        Set<ListNode> visited = new HashSet<>();
        while (head != null){
            if (visited.contains(head)) {
                sb.append(" -> ...");
                return sb.toString();
            }
            visited.add(head);
            sb.append(head.val);
            head = head.next;
        }
        return sb.toString();
    }
    
    public static ListNode of(int[] arr){
        ListNode preHead = new ListNode(0);
        ListNode head = preHead;
        for (int i = 0; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        return preHead.next;
    }
}
