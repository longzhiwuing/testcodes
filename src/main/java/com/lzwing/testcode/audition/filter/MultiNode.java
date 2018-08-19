package com.lzwing.testcode.audition.filter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/19
 * Time: 12:00
 */
public class MultiNode extends AbstractOperator {

    @Override
    public int handle(int result, Node node) {
        if (result == 0) {
            result =1;
        }

        result *= (int) node.getData();
        return result;
    }
}
