package com.lzwing.testcode.thread;
public class DeadThreadTest {
    public static void main(String[] args) {
        DeadThread thread = new DeadThread();
        Thread t1 = new Thread(thread);
        t1.setName("a");
        Thread t2 = new Thread(thread);
        t2.setName("b");
        t1.start();
        t2.start();
    }    
}

class DeadThread implements Runnable{
    private String o1= new String("o1");
    private String o2 = new String("o2");
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("a")){
            synchronized(o1){
                System.out.println("a thread  enter outer monitor o1....");
                try{
                    Thread.sleep(3000);
                    System.out.println("a waiting for o2 monitor...");
                    synchronized(o2){
                        System.out.println("a thread enter inner monitr o2");
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }                
            }
        }else{
            synchronized(o2){
                System.out.println("b thread  enter outer monitor o1....");
                try{
                    Thread.sleep(3000);
                    System.out.println("b waiting for o1 monitor...");
                    synchronized(o1){
                        System.out.println("b thread enter inner monitr o1");
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }                
            }
        }
    }
    
}