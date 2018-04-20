package com.lzwing.testcode.datastructor.linkedchain.test;

import com.lzwing.testcode.datastructor.linkedchain.myanswer.Node;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.lzwing.testcode.datastructor.linkedchain.myanswer.Node.*;
import static org.testng.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/22
 * Time: 16:11
 */
public class NodeTest {

    Node<Integer> head;

    private Node<Integer> initList() {
        Node<Integer> head = new Node<>(Integer.MIN_VALUE);
        int i=0;
        while (i < 10) {
            Node<Integer> node = new Node<>(i++);
            node.setNext(head.getNext());
            head.setNext(node);
        }
        return head;
    }

    private void showList(Node head) {
        Node dummyNode = head;
        StringBuilder sb = new StringBuilder();
        while (dummyNode != null) {
            if (dummyNode != head) {
                sb.append("=>");
                sb.append(dummyNode.getData());
            } else {
                sb.append("head");
            }
            dummyNode = dummyNode.getNext();
        }
        System.out.println(sb);
    }

    @BeforeTest
    public void before() {
        head = initList();

        showList(head);
    }

    @Test
    public void testShowList() {
        showList(head);
    }

    @Test
    public void testGetLength() throws Exception {
        assertEquals(getLength(head),10);
    }

    @Test
    public void testGetValueOfIndex() throws Exception {
        Integer valueOfIndex = (Integer)Node.getValueOfIndex(head, 3);
        assertEquals(valueOfIndex.intValue(), 7);
    }

    @Test
    public void testGetNodeIndex() throws Exception {
        int nodeIndex = getNodeIndex(head, 9);
        assertEquals(nodeIndex,0);
    }

    @Test
    public void testAddAtHead() throws Exception {
        addAtHead(head, 10);
        showList(head);
        assertEquals(getLength(head),11);
        assertEquals(getNodeIndex(head,10),0);
    }

    @Test
    public void testAddAtTail() throws Exception {
        addAtTail(head, -1);
        showList(head);
        assertEquals(getLength(head),11);
        assertEquals(getNodeIndex(head,-1),10);
    }

    @Test
    public void testInsertElement() throws Exception {
        insertElement(head, 100, 2);
        showList(head);

        assertEquals(getNodeIndex(head,100),2);
    }

    @Test
    public void testDeleteHead() throws Exception {
        deleteHead(head);

        showList(head);

        assertEquals(getLength(head),9);
    }

    @Test
    public void testDeleteTail() throws Exception {
        deleteTail(head);
        showList(head);

        assertEquals(getLength(head),9);
        deleteTail(head);
        showList(head);
        deleteTail(head);
        showList(head);
    }

    @Test
    public void testDeleteElement() throws Exception {
        deleteElement(head, 3);
        showList(head);

        assertEquals(getLength(head),9);
        assertEquals(getNodeIndex(head,5),3);
    }

    @Test
    public void testGetMiddleNode() throws Exception {
        Node middleNode = getMiddleNode(head);
        System.out.println(middleNode.getData());
    }

    @Test
    public void testIsLoopList() throws Exception {
        /*boolean loopList = isLoopList(head);
        assertEquals(false,loopList);*/

        Node loopHead = new Node(Integer.MAX_VALUE);

        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);

        loopHead.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1);

        boolean loopList = isLoopList(loopHead);
        assertEquals(true,loopList);

    }

    @Test
    public void testGetLoopSize() throws Exception {
        Node loopHead = new Node(Integer.MAX_VALUE);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        loopHead.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node2);

        int loopSize = getLoopSize(loopHead);
        System.out.println(loopSize);
    }
}