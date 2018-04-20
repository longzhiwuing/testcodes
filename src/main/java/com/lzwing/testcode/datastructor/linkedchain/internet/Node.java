package com.lzwing.testcode.datastructor.linkedchain.internet;

public class Node{
    //节点的值
    int value;
    //指向下一个节点的指针（java 中表现为下一个节点的引用）
    Node next;
    
    public void Node(int value){
        this.value = value;
    }

    public int getLength(Node head){

        if(head == null){
            return 0;
        }

        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    public int getValueOfIndex(Node head, int index) throws Exception {

        if (index < 0 || index >= getLength(head)) {
            throw new Exception("角标越界！");
        }

        if (head == null) {
            throw new Exception("当前链表为空！");
        }

        Node dummyHead = head;

        while (dummyHead.next != null && index > 0) {
            dummyHead = dummyHead.next;
            index--;
        }

        return dummyHead.value;
    }

    /** 获取节点值等于 value 的第一个元素角标 */
    public int getNodeIndex(Node head, int value) {

        int index = -1;
        Node dummyHead = head;

        while (dummyHead != null) {
            index++;
            if (dummyHead.value == value) {
                return index;
            }
            dummyHead = dummyHead.next;
        }

        return -1;
    }
}