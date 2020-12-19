package com.lzwing.testcode.audition.zcyProblems;

import java.util.Stack;

/**
 * 递归实现反转栈
 *
 * @author: chenzhongyong
 * Date: 2020/12/19
 * Time: 18:13
 */
public class ReverseStackByRecursiveProblem {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        reverseStack(stack);


        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int last = getAndRemoveLast(stack);
        reverseStack(stack);
        stack.push(last);
    }


    public static int getAndRemoveLast(Stack<Integer> stack) {
        Integer value = stack.pop();
        if (stack.isEmpty()) {
            return value;
        } else {
            int lastVal = getAndRemoveLast(stack);
            stack.push(value);
            return lastVal;
        }
    }
}
