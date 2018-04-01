package com.lzwing.testcode.linkedchain.doublelinkedlist;

import lombok.Data;

/**
 * 单个节点的数据结构
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/1
 * Time: 15:19
 */
@Data
public class Node<T> {
    T value;
    Node prev = this;
    Node next = this;

    Node(T t) {
        value = t;
    }
}