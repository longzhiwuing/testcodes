package com.lzwing.testcode.audition.zcyProblems;

import lombok.Data;

import java.util.Stack;

/**
 * O(1)获取栈最小值
 *
 * @author: chenzhongyong
 * Date: 2020/12/19
 * Time: 17:47
 */
public class GetMinStackProblem {

    public static void main(String[] args) {
        GetMinStackResolve();
    }

    private static void GetMinStackResolve() {
        GetMinStack stack = new GetMinStack();

        stack.push(3);
        System.out.println(stack.getMin());
        stack.push(2);
        System.out.println(stack.getMin());
        stack.push(1);
        System.out.println(stack.getMin());
        stack.push(5);
        System.out.println(stack.getMin());
        stack.push(4);
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

    @Data
    static class GetMinStack{

        private Stack<Integer> dataStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public Integer push(Integer item) {
            if (minStack.isEmpty()) {
                minStack.push(item);
            }
            if (minStack.peek() >= item) {
                minStack.push(item);
            }

            return dataStack.push(item);
        }

        public Integer pop(){
            Integer value = dataStack.pop();
            if (value.equals(minStack.peek())) {
                minStack.pop();
            }
            return value;
        }

        public Integer getMin() {
            if (minStack.isEmpty()) {
                return null;
            }
            return minStack.peek();
        }
    }
}
