package com.lzwing.testcode.linkedchain.doublelinkedlist;

import lombok.NonNull;

/**
 * 双向链表相关操作service
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/1
 * Time: 15:35
 */
public class DoubleLinkedListService {

    /**
     * 翻转双向链表
     * @param doubleLinkedList 原链表
     * @return 翻转后的链表
     */
    public DoubleLinkedList reverse(@NonNull DoubleLinkedList doubleLinkedList) {

        //curr指向当前节点，pre指向前一节点
        Node curr = doubleLinkedList.getHead();
        Node pre = null;
        Node next = null;

        //当pnode！=null时，开始反转
        while (curr != null) {
            //1、首先保存curr的下一节点保存到next，否则反转时会丢失下一节点指向。
            next = curr.getNext();
            //2、指向前一节点，当curr为头节点时，pre指针为空。
            curr.setNext(pre);
            //3、指向下一节点，当curr为尾节点时，next指针为空。
            curr.setPrev(next);
            //4、后移pre指针。
            pre = curr;
            //5、后移curr指针。
            curr = next;
        }

        return doubleLinkedList;
    }
}
