package com.lzwing.testcode.audition.filter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/19
 * Time: 11:59
 */
public class AddNode extends AbstractOperator {
    @Override
    public int handle(int result, Node node) {
        result +=(int)node.getData();
        return result;
    }
}
