package com.lzwing.testcode.datastructor.linkedchain.recursion;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/6
 * Time: 17:27
 */
@Data
public class Node<T> {

    private final T value;

    private Node next;
}
