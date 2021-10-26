package com.lzwing.link;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/10/25
 * Time: 22:24
 */
public class Node<T> {

    public T data;

    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data + "}";
    }
}
