package com.xiaoming.list3;

//单链表
class MyLinkedList1 {

    //size存储链表元素的个数
    private int size;
    //注意这里记录的是虚拟头结点
    private ListNode dummyHead;

    //初始化链表
    public MyLinkedList1() {
        this.size = 0;
        this.dummyHead = new ListNode(0);
    }

    public static void main(String[] args) {
        MyLinkedList1 linkedList = new MyLinkedList1();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        int a = linkedList.get(1);
        linkedList.deleteAtIndex(1);
        int b = linkedList.get(1);
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        ListNode current = dummyHead;
        while (index-- > 0) {
            current = current.next;
        }
        return current.next.val;
    }


    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是虚拟头结点
    public int get1(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = dummyHead;
        //第0个节点是虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        size++;
    }

    public void addAtHead1(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        size++;

        // 在链表最前面插入一个节点，等价于在第0个元素前添加
        // addAtIndex(0, val);
    }


    public void addAtTail(int val) {
        ListNode current = dummyHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
        size++;
    }

    public void addAtTail1(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        size++;

        // 在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
        // addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode current = dummyHead;
        while (index-- > 0) {
            current = current.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex1(int index, int val) {
        if (index > size) {
            return;
        }

        //找到要插入节点的前驱
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }
        ListNode current = dummyHead;
        while (index-- > 0) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    public void deleteAtIndex1(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        //因为有虚拟头节点，所以不用对index=0的情况进行特殊处理
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;
    }

    //成员内部类
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}