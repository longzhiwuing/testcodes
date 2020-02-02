package com.lzwing.testcode.oom;

public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalHolder threadLocalHolder = new ThreadLocalHolder();
        for(;;){
            Thread.sleep(10);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocalHolder.test();
                }
            }).start();
        }
    }
}

class ThreadLocalHolder{
    static final ThreadLocal<Byte[]> THREAD_LOCAL=new ThreadLocal<>();
    public void test(){
        Byte[] bytes=new Byte[1024*1024];
        System.out.println(Thread.currentThread().getName());
        THREAD_LOCAL.set(bytes);
        System.out.println("before-------------------------------------------"+THREAD_LOCAL.get());
//        THREAD_LOCAL.remove();
        System.out.println("after-------------------------------------------"+THREAD_LOCAL.get());
    }
}
