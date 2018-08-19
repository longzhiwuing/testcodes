package com.lzwing.testcode.audition.filter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/19
 * Time: 17:19
 */
public abstract class AbstractOperator implements Operator {
    @Override
    public int doProceed(Node node, MyRule rule) {
        int result = 0;

        Node<Integer> sentinel = node;

        while (sentinel != null) {
            if (rule.check(sentinel)) {
//                sum+=sentinel.getData();
                result = handle(result,sentinel);
            }
            sentinel = sentinel.getNext();
        }

        return result;
    }

    public abstract int handle(int result,Node node);
}
