package com.xiaoming.list2;

class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode res = removeElements2(head, 6);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
    }

    //原链表删除元素 注意返回head
    public static ListNode removeElements1(ListNode head, int val) {
        //删除头节点 注意用while！
        while (head != null && head.val == val) {
            head = head.next;
        }
        //临时指针 用来遍历链表 如果用头节点遍历 头节点所指向的值会改变 无法返回原先链表的头节点
        ListNode current = head;
        //删除其他节点
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    //虚拟头节点 注意返回dummyHead.next
    public static ListNode removeElements2(ListNode head, int val) {
        //设置虚拟头节点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode current = dummyHead;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        //注意head可能会被删了 所以返回dummyHead.next
        return dummyHead.next;
    }

    //递归
    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        // 假设 removeElements() 返回后面完整的已经去掉val节点的子链表
        // 在当前递归层用当前节点接住后面的子链表
        // 随后判断当前层的node是否需要被删除，如果是，就返回
        // 也可以先判断是否需要删除当前node，但是这样条件语句会比较不好想
        head.next = removeElements3(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;

        // 实际上就是还原一个从尾部开始重新构建链表的过程
    }
}