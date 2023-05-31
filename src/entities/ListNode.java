package entities;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
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
        while (head != null){
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
