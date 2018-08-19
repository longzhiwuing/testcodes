package com.lzwing.testcode.audition.filter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/19
 * Time: 11:37
 */
public class OddRule implements MyRule {
    @Override
    public boolean check(Node<Integer> node) {

        return node.getData()%2!=0;
    }
}
