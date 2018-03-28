package com.lzwing.testcode.linkedchain.myanswer;

import lombok.Data;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/22
 * Time: 15:59
 */
@Data
public class Node<T> {
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
    }

    public static int getLength(Node head) throws Exception {
        if (head == null) {
            throw new Exception("head不能为空");
        }

        int length = 0;

        while (head.getNext() != null) {
            length++;
            head = head.getNext();
        }

        return length;

    }

    /**
     * 获取指定角标的节点值
     */
    public static Object getValueOfIndex(Node head, int index) throws Exception {
        if (index < 0 || index > getLength(head)) {
            throw new Exception("越界");
        }

        if (head == null) {
            throw new Exception("head不能为空");
        }

        int i = 0;

        while (i++ < index) {
            head = head.getNext();
        }

        return head.getData();
    }

    /**
     * 获取节点值等于 value 的第一个元素角标
     */
    public static int getNodeIndex(Node head, Integer value) throws Exception {
        if (head == null) {
            throw new Exception("head不能为空");
        }

        int index = 0;

        while (head.getNext() != null) {
            Node node = head.getNext();
            if (Objects.equals(value, node.getData())) {
                return index;
            }
            head = head.getNext();
            index++;
        }

        return -1;
    }

    /**
     * 在已有链表头部插入一个节点
     */
    public static Node addAtHead(Node head, int value) throws Exception {
        if (head == null) {
            throw new Exception("head不能为空");
        }

        Node newNode = new Node(value);
        newNode.setNext(head.getNext());
        head.setNext(newNode);

        return head;
    }

    public static Node addAtTail(Node head, int value) throws Exception {
        if (head == null) {
            throw new Exception("head不能为空");
        }

        Node dummyNode = head;

        while (dummyNode.getNext() != null) {
            dummyNode = dummyNode.getNext();
        }

        Node newNode = new Node(value);
        dummyNode.setNext(newNode);

        return head;
    }

    // 注意这里 index 从 0 开始
    public static Node insertElement(Node head, int value, int index) throws Exception {
        if (head == null) {
            throw new Exception("head不能为空");
        }

        if (index < 0 || index > getLength(head)) {
            throw new Exception("越界");
        }

        Node dummyNode = head;

        for (int i = 0; i < index; i++) {
            dummyNode = dummyNode.getNext();
        }

        Node newNode = new Node(value);

        newNode.setNext(dummyNode.getNext());
        dummyNode.setNext(newNode);

        return head;

    }


    /**
     * 删除头部节点 也就是删除索引为 0 的节点：
     */
    public static Node deleteHead(Node head) throws Exception {

        if (head == null || head.getNext() == null) {
            throw new Exception("没有第一个节点");
        }

        Node dummyNode = head.getNext();

        head.setNext(head.getNext().getNext());

        dummyNode = null;

        return head;
    }

    /**
     * 删除尾节点
     */
    public static Node deleteTail(Node head) throws Exception {
        if (head == null || head.getNext() == null) {
            throw new Exception("head不能为空,也不能只有头结点");
        }

        Node dummyNode = head;

        while (dummyNode.getNext().getNext() != null) {
            dummyNode = dummyNode.getNext();
        }

        dummyNode.setNext(null);

        return head;
    }

    /**
     * 删除指定索引的节点：
     */
    public static Node deleteElement(Node head, int index) throws Exception {
        if (head == null) {
            throw new Exception("不能为空");
        }

        if (index < 0 || index > getLength(head)) {
            throw new Exception("越界");
        }

        Node preDelNode = head;

        for (int i = 0; i < index; i++) {
            preDelNode = preDelNode.getNext();
        }

        Node node2delete = preDelNode.getNext();

        preDelNode.setNext(node2delete.getNext());

        node2delete = null;

        return head;
    }

    public static Node getMiddleNode(Node head) throws Exception {
        if (head == null) {
            throw new Exception("不能为空");
        }

        Node fast = head;
        Node slow = head;

        while (fast.getNext() != null) {
            fast = fast.getNext();
            if (fast.getNext() != null) {
                fast = fast.getNext();
                slow = slow.getNext();
            }
        }

        return slow;
    }

    public static boolean isLoopList(Node head) throws Exception {
        if (head == null) {
            throw new Exception("不能为空");
        }

        Node fast = head;
        Node slow = head;

        boolean isLoop = false;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast == slow) {
                isLoop = true;
                break;
            }
        }

        return isLoop;
    }

    public static int getLoopSize(Node head) throws Exception{
        if (head == null) {
            throw new Exception("不能为空");
        }

        Node fast = head;
        Node slow = head;

        int count = 0;
        int meetTime = 2;

        while (meetTime>0) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast == slow) {
                meetTime--;
            }

            if (meetTime == 1) {
                count++;
            }

        }

        return count;

    }
}
