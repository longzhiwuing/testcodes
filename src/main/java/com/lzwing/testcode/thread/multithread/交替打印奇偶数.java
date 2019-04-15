package com.lzwing.testcode.thread.multithread;

public class 交替打印奇偶数 {


    static class Solution implements Runnable{

        private static int i = 0;

        @Override
        public void run() {
            while (i < 100) {
                synchronized (Solution.class) {
                    System.out.println(Thread.currentThread().getName() + ",num:" + this.i++);
                    Solution.class.notify();
                    try {
                        Solution.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
         new Thread(new Solution(),"奇数").start();
         new Thread(new Solution(),"偶数").start();
    }
}