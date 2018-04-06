package com.lzwing.testcode.linkedchain.recursion;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/6
 * Time: 17:28
 */
public class LinkedListDemo {

    public static Node createLinkedList(List<Integer> values) {

        if (values == null || values.size() == 0) {
            return null;
        }

        Node<Integer> addNode = new Node<Integer>(values.get(0));

        addNode.setNext(createLinkedList(values.subList(1, values.size())));

        return addNode;
    }

    public static Node reverseList(Node head) {

        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        Node newHead = reverseList(head.getNext());

        Node next = head.getNext().getNext();

        head.getNext().setNext(head);

        head.setNext(next);

        return newHead;
    }

    public static void showLinkedList(Node node) {
        System.out.println("linkedList:");
        Node tmp = node;
        while (tmp != null) {
            System.out.print(tmp.getValue());
            tmp = tmp.getNext();
            if (tmp != null) {
                System.out.print("->");
            }
        }
    }

    public static void main(String[] args) {
//        testCreateLinkedList();

        testReserve();

    }

    private static void testReserve() {
//        Node linkedList = createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
//        Node linkedList = createLinkedList(Arrays.asList(1));
        Node linkedList = createLinkedList(Arrays.asList());
        Node reverseHead = reverseList(linkedList);
        showLinkedList(reverseHead);
    }

    private static void testCreateLinkedList() {
        //        Node linkedList = createLinkedList(Arrays.asList(1, 2, 3, 4, 5));
//        Node linkedList = createLinkedList(Arrays.asList(1));
        Node linkedList = createLinkedList(Arrays.asList());
        showLinkedList(linkedList);
    }
}
