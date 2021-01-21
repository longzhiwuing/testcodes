package com.lzwing.testcode.thread.multithread;

class TicketWindows implements Runnable {
    private int tickets = 20;// 总票数

    public void run() {
        while (true) {
            synchronized (this) {
                // if else 要保证其原子行 同步代码块
                if (tickets > 0) {
                    // 显示售票信息
                    System.out.println(Thread.currentThread().getName() + "正在售票中   ....第 " + tickets + "张票");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tickets--;
                    System.out.println("票还余: " + tickets + "张 ...");
                } else {
                    // 退出售票窗口
                    break;
                }
                // 判断是否还有票
            }
        }
    }

    public static class TestTickets {

        public static void main(String[] args) {

            TicketWindows tWindows1 = new TicketWindows();
            Thread thread1 = new Thread(tWindows1);
            Thread thread2 = new Thread(tWindows1);
            Thread thread3 = new Thread(tWindows1);
            thread1.start();
            thread2.start();
            thread3.start();

        }

    }
}