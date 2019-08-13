package com.lzwing.testcode.thread.gist;

public class MyThread extends Thread{

    @Override
    public void run(){
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("i am waiting but facing interruptexception now");
            }
        }
    }
}