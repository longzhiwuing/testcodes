package com.lzwing.testcode.datastructor.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/15
 * Time: 14:29
 */
public class QueueWith2Stacks {
    Deque<Integer> s1;
    Deque<Integer> s2;

    public QueueWith2Stacks() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void addFirst(Integer itm) {
        s1.push(itm);
    }

    public Integer pollLast() {

        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        Integer res = s1.pop();

        while (s2.size() > 0) {
            s1.push(s2.pop());
        }

        return res;
    }

    public int size() {
        return s1.size();
    }

    public static void main(String[] args) {
//        Deque<Integer> queue = new LinkedList<>();
        QueueWith2Stacks queue = new QueueWith2Stacks();

        queue.addFirst(1);
        queue.addFirst(2);
        queue.addFirst(3);
        queue.pollLast();
        queue.pollLast();
        queue.addFirst(5);
        queue.addFirst(7);
        queue.addFirst(9);

        while (queue.size()>0) {
            System.out.println(queue.pollLast());
        }
    }
}
