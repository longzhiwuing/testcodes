package com.lzwing.link;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/10/25
 * Time: 22:25
 */
public class Tester {


    public static void main(String[] args) {
        Node head = generateNodeLink(10);

        printLink(head);

        reverseLink(head);

        printLink(head);
    }

    private static Node reverseLink(Node head) {
        Node curr = head.next;
        if (Objects.isNull(curr)) {
            return head;
        }
        Node next = null;
        while (Objects.nonNull(curr)) {
            Node tmp = curr;
            curr = curr.next;
            tmp.next = next;
            next = tmp;
            head.next = tmp;
        }

        return head;
    }

    private static void printLink(Node head) {
        Node curr = head.next;
        StringJoiner sj = new StringJoiner(" -> ");
        while (Objects.nonNull(curr)) {
            sj.add(String.valueOf(curr.data));
            curr = curr.next;
        }

        System.out.println(sj.toString());
    }

    private static Node generateNodeLink(int size) {
        Node head = new Node(null);

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Node node = new Node(i + 1);
            nodes.add(node);
        }

        for (int i = 0; i < size; i++) {

            if (i != size - 1) {
                nodes.get(i).next = nodes.get(i + 1);
            }
        }

        head.next = nodes.get(0);

        return head;
    }
}
