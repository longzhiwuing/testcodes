package com.lzwing.testcode.audition.filter;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/19
 * Time: 11:28
 */
@Data
@Accessors(chain = true)
public class Node<T> {
    T data;
    Node<T> next;

    public Node() {
    }

    public Node(T t) {
        this.data = t;
    }
}
