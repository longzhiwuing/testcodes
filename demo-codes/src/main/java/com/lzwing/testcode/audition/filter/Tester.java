package com.lzwing.testcode.audition.filter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/19
 * Time: 11:29
 */
public class Tester {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);


        MyRule rule = new OddRule();

        rule = new EvenRule();

        Operator op = new AddNode();

//        op = new MultiNode();

        int sum = op.doProceed(n1, rule);

        System.out.println("sum = " + sum);
    }
}
