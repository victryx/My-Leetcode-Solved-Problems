package easy;
import entities.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LC234_PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1 ,
            new ListNode(2)
        );
        System.out.println(isPalindrome(head));
    }

    /**
     * <b>1st Try.</b> <br />
     * Turn LinkedList into arrayList <br />
     * SOLVED: 27-05-2023
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null){
            list.add(head.val);
            head=head.next;
        }

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            if (list.get(i) != list.get(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        return false;
    }
}
