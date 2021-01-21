package com.lzwing.testcode.gist.innerclass4java8;

public class TestInnerClass {
    public static void main(String[] args) {
        try {
            Test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void Test() throws InterruptedException {
        System.out.println("Start of program.");

        ClassOuter outer = new ClassOuter();
        Object object = outer.object;
        outer = null;
        //如果不添加下面这句话，会导致内部对象无法释放而出现内存泄露
        //object = null;

        System.out.println("Execute GC");
        System.gc();

        Thread.sleep(3000);
        System.out.println("End of program.");
    }
}