package com.xiaoming.list8;

public class Solution {
    public static void main(String[] args) {
        // 构建链表：1 -> 2 -> 3 -> 4 -> 5 -> 3（形成环，入口节点是 3）
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 让最后一个节点指向节点3，形成环
        head.next.next.next.next.next = head.next.next;

        // 调用检测函数
        Solution solution = new Solution();
        ListNode entry = solution.detectCycle(head);

        // 输出结果
        if (entry != null) {
            System.out.println("环的入口节点是: " + entry.val);
        } else {
            System.out.println("没有检测到环。");
        }
    }

    //公式 x = (n−1)(y+z) + z 说明：从头到入口的距离 x，等于从相遇点再走 z 步（绕过若干整圈后）的位置。
    //因此，只要两指针以**相同速度（每次走一步）**前进，它们会在环入口相遇。
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { //有环
                ListNode index1 = head;
                ListNode index2 = fast;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
