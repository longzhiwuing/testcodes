package com.lzwing.demo.test.circularref;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/8/5
 * Time: 15:42
 */
public class StackOverFlowTest {
    public static void main(String[] args) {
        System.out.println(new A());
    }
}

class AA {
    public AA() {
        new BB();
    }
}

class BB {
    public BB() {
        new AA();
    }
}
