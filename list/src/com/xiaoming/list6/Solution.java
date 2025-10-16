package com.xiaoming.list6;

class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode swapHead = removeNthFromEnd1(head, 6);
        while (swapHead != null) {
            System.out.print(swapHead.val);
            swapHead = swapHead.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        int count = 0;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        if (n < 0 || n > count) return null;
        cur = dummyHead;
        for (int i = 0; i < count - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }

    //使用双指针 让快指针先走n+1步 然后一起走 快指针指到null的时候 满指针就指到了倒数第n+1个
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
            if (fast == null && i < n) return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}