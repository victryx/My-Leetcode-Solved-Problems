package medium;

import entities.ListNode;

import java.math.BigInteger;

public class LC2_AddTwoNumbers {

    public static void main(String[] args) {
        ListNode linkedList = addTwoNumbers(ListNode.of(new int[]{9}), ListNode.of(new int []{1,9,9,9,9,9,9,9,9,9}));
        System.out.println(linkedList);
    }

    /**
     * <b>1st Try.</b> <br />
     * Linked list to number and number to linked list<br />
     * This approach must be wrong, but it works <br />
     * Solved: 2023-05-31
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum = toNumber(l1).add(toNumber(l2));
        return toList(sum);
    }

    public static BigInteger toNumber(ListNode head) {
        BigInteger i = BigInteger.valueOf(1);
        BigInteger num = BigInteger.valueOf(0);
        while (head != null) {
            num = num.add( i.multiply(BigInteger.valueOf(head.val)) );
            i = i.multiply(BigInteger.valueOf(10));
            head = head.next;
        }
        return num;
    }

    public static ListNode toList(BigInteger number) {
        if (number.equals(BigInteger.ZERO)) return new ListNode(0);
        ListNode preHead = new ListNode(0);
        ListNode head = preHead;
        while (number.compareTo(BigInteger.ZERO) > 0){
            head.next = new ListNode((number.mod(BigInteger.valueOf(10)).intValue()));
            number = number.divide(BigInteger.valueOf(10));
            head = head.next;
        }

        return preHead.next;
    }

    /**
     * Set solution<br />
     * SOURCE: <a href="https://leetcode.com/problems/add-two-numbers/solutions/1835535/java-c-a-very-beautiful-explanation-ever-exists/">Leetcode</a>
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
        }
        return dummy.next;
    }
}
