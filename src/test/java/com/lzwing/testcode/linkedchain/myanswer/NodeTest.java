package com.lzwing.testcode.linkedchain.myanswer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static com.lzwing.testcode.linkedchain.myanswer.Node.*;


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
    }

    @Test
    public void testShowList() {
        showList(head);
    }

    @Test
    public void testGetLength() throws Exception {
        assertEquals(Node.getLength(head),10);
    }

    @Test
    public void testGetValueOfIndex() throws Exception {
        Integer valueOfIndex = (Integer)Node.getValueOfIndex(head, 3);
        assertEquals(valueOfIndex.intValue(), 7);
    }

    @Test
    public void testGetNodeIndex() throws Exception {
        int nodeIndex = Node.getNodeIndex(head, 9);
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
        showList(head);
        deleteElement(head, 3);
        showList(head);

        assertEquals(getLength(head),9);
        assertEquals(getNodeIndex(head,5),3);
    }
}