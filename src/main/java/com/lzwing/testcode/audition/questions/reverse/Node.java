package com.lzwing.testcode.audition.questions.reverse;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/8/11
 * Time: 22:19
 */
@Data
@NoArgsConstructor
public class Node {

    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
    }
}
