package com.lty.lls.main;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Algorithm {
    /**
     * Approach 1: Elementary Math
     * Time complexity:O(max(m,n))
     * Space comlexity:O(max(m,n) + 1)
     *
     * @param l1
     * @param l2
     * @param carry
     * @return
     */
    public static ListNode addTwoNumbers01(ListNode l1, ListNode l2, int carry) {
        /**
         * Keep track of the carry using a variable and simulate digits-by-digits sum starting from the head of list, which contains the least-significant digit.
         */
        int curCarry = carry;
        if (l1 != null && l2 != null) {
            if (l1.val + l2.val + carry >= 10) {
                l1.val = l1.val - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            return new ListNode(l1.val + l2.val + curCarry, addTwoNumbers01(l1.next, l2.next, carry));
        } else if (l1 != null) {
            if (l1.val + carry >= 10) {
                carry = 1;
                l1.val = l1.val - 10;
            } else {
                carry = 0;
            }
            return new ListNode(l1.val + curCarry, addTwoNumbers01(l1.next, null, carry));
        } else if (l2 != null) {
            if (l2.val + carry >= 10) {
                carry = 1;
                l2.val = l2.val - 10;
            } else {
                carry = 0;
            }
            return new ListNode(l2.val + curCarry, addTwoNumbers01(null, l2.next, carry));
        } else if (curCarry > 0) {
            return new ListNode(1);
        }
        return null;
    }

    /**
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        /**
         * Keep track of the carry using a variable and simulate digits-by-digits sum starting from the head of list, which contains the least-significant digit.
         */
        //Initialize current node to dummy head of the returning list.
        ListNode dummyHead = new ListNode();
        int carry = 0;
        //Initialize p and q to head of l1 and l2 respectively.
        ListNode p = l1, q = l2, curr = dummyHead;
        //Loop through lists l1 and l2 until you reach both ends.
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
