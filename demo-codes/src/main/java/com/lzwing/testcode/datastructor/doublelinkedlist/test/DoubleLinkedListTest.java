package com.lzwing.testcode.datastructor.doublelinkedlist.test;

import com.lzwing.testcode.datastructor.doublelinkedlist.DoubleLinkedList;
import com.lzwing.testcode.datastructor.doublelinkedlist.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 双向链表数据结构的单元测试
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/1
 * Time: 15:27
 */
public class DoubleLinkedListTest {

    DoubleLinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new DoubleLinkedList<Integer>();

    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void addNormal() {
        list.add(0,1);
        assertEquals(1,list.getHead().getNext().getValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addBeforeException() {
        list.add(-1, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAfterException() {
        list.add(2, null);
    }

    @Test
    public void get() {
        list.add(0,1);

        Node node = list.get(0);

        assertEquals(1,node.getValue());
    }

    @Test
    public void size() {
        assertEquals(0,list.size());
        list.add(0,1);
        assertEquals(1,list.size());
    }

    @Test
    public void addFirst() {

        list.addFirst(null);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(4,list.size());

        assertEquals(3,list.getHead().getNext().getValue());
        assertEquals(2,list.getHead().getNext().getNext().getValue());
        assertEquals(1,list.getHead().getNext().getNext().getNext().getValue());
        assertEquals(null,list.getHead().getNext().getNext().getNext().getNext().getValue());
    }

    @Test
    public void addLast() {
        list.addLast(null);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(4,list.size());

        assertEquals(null,list.getHead().getNext().getValue());
        assertEquals(1,list.getHead().getNext().getNext().getValue());
        assertEquals(2,list.getHead().getNext().getNext().getNext().getValue());
        assertEquals(3,list.getHead().getNext().getNext().getNext().getNext().getValue());
    }

    @Test
    public void remove() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.remove(1);

        assertEquals(2,list.size());
        assertEquals(3,list.getHead().getNext().getValue());
        assertEquals(1,list.getHead().getNext().getNext().getValue());
    }

    @Test
    public void removeFirst() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.removeFirst();

        assertEquals(2,list.size());
        assertEquals(2,list.getHead().getNext().getValue());
        assertEquals(1,list.getHead().getNext().getNext().getValue());
    }

    @Test
    public void removeLast() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.removeLast();

        assertEquals(2,list.size());
        assertEquals(3,list.getHead().getNext().getValue());
        assertEquals(2,list.getHead().getNext().getNext().getValue());
    }





}