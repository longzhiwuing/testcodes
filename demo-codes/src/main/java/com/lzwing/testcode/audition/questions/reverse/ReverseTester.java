package com.lzwing.testcode.audition.questions.reverse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/10/29
 * Time: 17:20
 */
@SuppressWarnings("Duplicates")
public class ReverseTester {
    private static Node init() {
        Node header = new Node();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        header.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        return header;
    }

    public static void main(String[] args) {
        Node header = init();

        Node newHeader = reverse(header);

        print(newHeader);
    }

    private static Node reverse(Node header) {
        if (header == null || header.getNext() == null) {
            return header;
        }

        Node newNext = null;
        Node current = header.getNext();

        while (current.getNext() != null) {
            Node next = current.getNext();
            current.setNext(newNext);
            newNext = current;
            current = next;
        }

        current.setNext(newNext);

        header.setNext(current);

        return header;

    }

    private static void print(Node header) {
        if (header == null || header.getNext() == null) {
            System.out.println("none link");
        }

        Node temp = header.getNext();
        while (temp!=null) {
            System.out.println(temp.getVal());
            temp = temp.getNext();
        }
    }
}
