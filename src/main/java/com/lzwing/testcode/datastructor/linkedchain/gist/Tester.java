package com.lzwing.testcode.datastructor.linkedchain.gist;

import com.google.common.collect.Lists;
import com.lzwing.testcode.datastructor.linkedchain.recursion.LinkedListDemo;
import com.lzwing.testcode.datastructor.linkedchain.recursion.Node;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/11/11
 * Time: 12:06
 */
public class Tester {
    public static void main(String[] args) {
        List<Integer> dataList = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        Node linkedList = LinkedListDemo.createLinkedList(dataList);

        Node head = new Node("head");
        head.setNext(linkedList);

        head = recurseReverse(head);


        LinkedListDemo.showLinkedList(head);


    }

    private static Node recurseReverse(Node head) {
        Node curr = head.getNext();
        if (curr == null || curr.getNext() == null) {
            head.setNext(curr);
            return head;
        }
        head.setNext(curr.getNext());
        head = recurseReverse(head);

        Node temp = curr.getNext();
        curr.setNext(null);
        temp.setNext(curr);

        return head;

    }
}
