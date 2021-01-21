package com.lzwing.testcode.datastructor.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/15
 * Time: 13:27
 */
public class StackWith2Queues {
    Deque<Integer> q1;
    Deque<Integer> q2;

    public StackWith2Queues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(Integer itm) {
        q1.addLast(itm);
    }

    public Integer pop() {
        while (q1.size() > 1) {
            q2.addLast(q1.pollFirst());
        }

        Integer res = q1.pollFirst();
        q1 = q2;
        q2 = new LinkedList<>();

        return res;
    }

    public int size() {
        return q1.size();
    }

    public static void main(String[] args) {
//        Deque<Integer> stack = new LinkedList<>();
        StackWith2Queues stack = new StackWith2Queues();

        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }


    }

}
