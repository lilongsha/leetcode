package com.lty.lls.main;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Algorithm {
    /**
     * Approach 1: Elementary Math
     * @param l1
     * @param l2
     * @param carry
     * @return
     */
    public static ListNode addTwoNumbers01(ListNode l1, ListNode l2, int carry) {
        int curCarry = carry;
        if (l1 != null && l2 != null) {
            if(l1.val + l2.val + carry >= 10){
                l1.val = l1.val - 10;
                carry = 1;
            }else{
                carry = 0;
            }
            return new ListNode(l1.val + l2.val + curCarry, addTwoNumbers01(l1.next, l2.next, carry));
        } else if (l1 != null) {
            if(l1.val + carry >= 10) {
                carry = 1;
                l1.val = l1.val - 10;
            }else{
                carry = 0;
            }
            return new ListNode(l1.val + curCarry, addTwoNumbers01(l1.next, null, carry));
        } else if (l2 != null) {
            if(l2.val + carry >= 10) {
                carry = 1;
                l2.val = l2.val - 10;
            }else{
                carry = 0;
            }
            return new ListNode(l2.val + curCarry, addTwoNumbers01(null, l2.next, carry));
        }else if (curCarry > 0){
            return new ListNode(1);
        }
        return null;
    }
}
