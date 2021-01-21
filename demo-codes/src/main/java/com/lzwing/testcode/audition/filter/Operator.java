package com.lzwing.testcode.audition.filter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/19
 * Time: 11:58
 */
public interface Operator {

    int doProceed(Node node,MyRule rule);
}
