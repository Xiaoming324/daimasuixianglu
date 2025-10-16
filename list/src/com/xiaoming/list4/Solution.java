package com.xiaoming.list4;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode reversedHead = reverseList2(head);
        while (reversedHead != null) {
            System.out.print(reversedHead.val);
            reversedHead = reversedHead.next;
        }
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur; //先移pre
            cur = temp; //后移cur
        }
        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    public static ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }
}
