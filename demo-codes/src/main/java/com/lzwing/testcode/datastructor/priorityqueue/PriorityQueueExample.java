package com.lzwing.testcode.datastructor.priorityqueue;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;

@Slf4j
public class PriorityQueueExample {
 
    public static void main(String[] args) {

        //优先队列自然排序示例
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
        /*Random rand = new Random();
        for(int i=0;i<7;i++){
            integerPriorityQueue.add(new Integer(rand.nextInt(100)));
        }
        for(int i=0;i<7;i++){
            Integer in = integerPriorityQueue.poll();
            System.out.println("Processing Integer:"+in);
        }*/

        List<Integer> ranmdomList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ranmdomList.add(RandomUtils.nextInt(0, 100));
        }

        log.info("ranmdomList:{}", ranmdomList);

        integerPriorityQueue.addAll(ranmdomList);

        System.out.println(integerPriorityQueue.poll());
        System.out.println(integerPriorityQueue.poll());
        System.out.println(integerPriorityQueue.poll());



 
        /*//优先队列使用示例
        Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
        addDataToQueue(customerPriorityQueue);
 
        pollDataFromQueue(customerPriorityQueue);*/
 
    }
 
    //匿名Comparator实现
    public static Comparator<Customer> idComparator = new Comparator<Customer>(){
 
        @Override
        public int compare(Customer c1, Customer c2) {
            return (int) (c1.getId() - c2.getId());
        }
    };
 
    //用于往队列增加数据的通用方法
    private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
        Random rand = new Random();
        for(int i=0; i<7; i++){
            int id = rand.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "Pankaj "+id));
        }
    }
 
    //用于从队列取数据的通用方法
    private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
        while(true){
            Customer cust = customerPriorityQueue.poll();
            if(cust == null) break;
            System.out.println("Processing Customer with ID="+cust.getId());
        }
    }
 
}