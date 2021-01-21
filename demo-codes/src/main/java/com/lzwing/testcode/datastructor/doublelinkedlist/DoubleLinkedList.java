package com.lzwing.testcode.datastructor.doublelinkedlist;


import lombok.Data;

/**
 * 一个双向链表的数据结构
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/1
 * Time: 15:20
 */
@Data
public class DoubleLinkedList<T> {

    private Node head = new Node(null);
    private int size;

    public boolean addFirst(T data) {
        addAfter(new Node(data), head);
        return true;
    }

    public boolean addLast(T data) {
        addBefore(new Node(data), head);
        return true;
    }

    public boolean add(int index, T data) {
        addBefore(new Node(data), getNode(index));
        return true;
    }

    public boolean remove(int index) {
        removeNode(getNode(index));
        return true;
    }

    public boolean removeFirst() {
        removeNode(head.next);
        return true;
    }

    public boolean removeLast() {
        removeNode(head.prev);
        return true;
    }

    public Node get(int index) {
        return getNode(index);
    }

    public int size() {
        return size;
    }

    public Node getNode(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Node node = head.next;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    private void addBefore(Node newNode, Node node) {
        newNode.next = node;
        newNode.prev = node.prev;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        size++;
    }

    private void addAfter(Node newNode, Node node) {
        newNode.prev = node;
        newNode.next = node.next;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        size++;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--;
    }
}