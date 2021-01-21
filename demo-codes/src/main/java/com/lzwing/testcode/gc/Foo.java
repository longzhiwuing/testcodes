package com.lzwing.testcode.gc;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/26
 * Time: 10:56
 */
public class Foo {
    public Foo() {
        byte[] bytes = new byte[102400];
        System.out.println("Foo init......");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize......Foo被GC回收了");
        super.finalize();
    }

    public void out() {
        System.out.println("Foo 执行out函数");
    }
}
