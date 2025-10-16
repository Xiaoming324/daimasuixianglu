package com.xiaoming.list7;

class Solution {
    public static void main(String[] args) {
        // ====== 构造有交点的情况 ======
        // 公共部分：4 -> 5 -> 6
        ListNode common = new ListNode(4);
        common.next = new ListNode(5);
        common.next.next = new ListNode(6);

        // 链表A：1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = common; // 从4开始相交

        // 链表B：9 -> 4 -> 5 -> 6
        ListNode headB = new ListNode(9);
        headB.next = common; // 直接指向公共部分

        Solution solution = new Solution();
        ListNode intersection = solution.getIntersectionNode(headA, headB);
        System.out.println("有交点测试：");
        if (intersection != null) {
            System.out.println("相交节点值为：" + intersection.val);
        } else {
            System.out.println("无交点");
        }

        // ====== 构造无交点的情况 ======
        ListNode headC = new ListNode(1);
        headC.next = new ListNode(2);
        headC.next.next = new ListNode(3);

        ListNode headD = new ListNode(4);
        headD.next = new ListNode(5);

        ListNode noIntersection = solution.getIntersectionNode(headC, headD);
        System.out.println("\n无交点测试：");
        if (noIntersection != null) {
            System.out.println("相交节点值为：" + noIntersection.val);
        } else {
            System.out.println("无交点");
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                curB = curB.next;
            }
        }

        while (curA != null && curB != null) {
            if (curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }

    //双指针切换法的核心思想是：
    //让两个指针走相同的总路径长度（A+B），从而自然在交点处相遇。
    // 1 2 4 5 6 null 3 4 5 6
    // 3 4 5 6 null 1 2 4 5 6
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
}