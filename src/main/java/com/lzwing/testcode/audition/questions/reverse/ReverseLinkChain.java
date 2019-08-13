package com.lzwing.testcode.audition.questions.reverse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/8/11
 * Time: 22:19
 */
public class ReverseLinkChain {
    public static void main(String[] args) {
        Node header = init();

        header = reverse(header.getNext());

        print(header);


//       Node newHeader = reverseK(header, 3);

    }

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

    private static Node reverseK(Node header, int k) {
        return null;
    }

    private static Node reverse(Node header) {

        if (header == null || header.getNext() == null) {
            return header;
        }

        // 1->2->3->4->5->6->7->8->null


        Node pre = null;
        Node next = null;
        while (header != null) {
            next = header.getNext();

            header.setNext(pre);
            pre = header;
            header = next;
        }

        return pre;

        //my version
        /*Node pre = null;
        Node curr = header.getNext();
        Node next = curr.getNext();
        while (next != null) {
            curr.setNext(pre);
            pre = curr;
            curr = next;
            next = next.getNext();
        }
        curr.setNext(pre);
        header.setNext(curr);

        return header;*/


        /*Node curr = header.getNext();
        Node pre = null;
        Node tmp = curr.getNext();
        while (tmp != null) {
            curr.setNext(pre);
            pre = curr;
            curr = tmp;
            tmp = tmp.getNext();
        }

        return curr;*/
    }

    private static void print(Node header) {
        Node p = header.getNext();

        while (p != null) {
            System.out.println(p.getVal());
            p = p.getNext();
        }
    }
}
