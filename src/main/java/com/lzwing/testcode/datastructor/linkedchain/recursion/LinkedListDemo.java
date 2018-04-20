package com.lzwing.testcode.datastructor.linkedchain.recursion;

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

        System.out.println();
    }

    public static void main(String[] args) {
//        testCreateLinkedList();

//        testReserve();

        testDeleteif();

    }

    private static void testDeleteif() {
//        Node linkedList = createLinkedList(Arrays.asList(1, 2, 2, 2, 3, 4, 5, 3, 2, 1));
//        Node linkedList = createLinkedList(Arrays.asList(1, 1, 1, 1, 2, 3, 4, 5, 3, 2, 1));
        Node linkedList = createLinkedList(Arrays.asList(1, 1, 1, 1, 1));
//        Node linkedList = createLinkedList(Arrays.asList(1,2,3,4,5));

        showLinkedList(linkedList);

        Node rest = deleteIf(linkedList, 1);

        showLinkedList(rest);
    }

    private static Node deleteIf(Node head, int i) {

        Node prev = head;

        if (prev == null) {
            return null;
        }

        while (head != null && prev.getValue().equals(i)) {
            head = head.getNext();
            prev = head;
        }

        while (prev != null && prev.getNext() != null) {
            Node node2del = prev.getNext();
            while (node2del != null && node2del.getValue().equals(i)) {
                prev.setNext(node2del.getNext());
                node2del = prev.getNext();
            }

            prev = prev.getNext();
        }

        return head;

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
