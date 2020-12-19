package com.lzwing.testcode.audition.zcyProblems;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author: chenzhongyong
 * Date: 2020/12/19
 * Time: 17:49
 */
public class Stack2queueProblem {

    public static void main(String[] args) {

        Stack2queue queue = new Stack2queue();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.add(6);
        queue.add(7);
        queue.add(8);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    static class Stack2queue{
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();

        public Integer add(Integer newNum) {
            return pushStack.push(newNum);
        }

        public Integer poll() {
            handlePopStack();

            return popStack.pop();
        }

        private void handlePopStack() {

            if (pushStack.isEmpty() && popStack.isEmpty()) {
                throw new RuntimeException("none elem");
            } else if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }

        public Integer peek() {

            handlePopStack();

            return popStack.peek();
        }
    }
}
