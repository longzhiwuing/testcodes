package com.lzwing.testcode.datastructor.delayqueue;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Data
public class Order implements Delayed {

    private String name ;
    private long start = System.currentTimeMillis();
    private long time ;

    public Order(String name,long time) {
        this.name = name;
        this.time = time;
    }

    /**
     * 需要实现的接口，获得延迟时间   用过期时间-当前时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((start+time) - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    /**
     * 延迟队列内部排序   当前对象延迟时间 - 入参对象的延迟时间
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        Order o1 = (Order) o;
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o1.getDelay(TimeUnit.MILLISECONDS));
    }
}