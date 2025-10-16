package com.xiaoming.list5;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode swapHead = swapPairs1(head);
        while (swapHead != null) {
            System.out.print(swapHead.val);
            swapHead = swapHead.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) { // cur.next != null 必须先写 防止cur.next.next空指针异常
            ListNode temp = cur.next;
            ListNode temp1 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = temp;
            temp.next = temp1;
            cur = cur.next.next;
        }
        return dummyHead.next;
    }

    //精简版本 将步骤 2,3 交换顺序，这样不用定义 temp 节点
    public static ListNode swapPairs1(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) { // cur.next != null 必须先写 防止cur.next.next空指针异常
            ListNode first = cur.next;
            cur.next = first.next;
            first.next = cur.next.next;
            cur.next.next = first;
            cur = cur.next.next;
        }
        return dummyHead.next;
    }

    //递归 看不懂。。。
    public ListNode swapPairs2(ListNode head) {
        // base case 退出提交
        if (head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs2(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
}
