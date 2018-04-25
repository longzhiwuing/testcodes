package com.lzwing.testcode.datastructor.sort;

import org.springframework.util.StopWatch;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/25
 * Time: 22:37
 */
public class TimerSorter<T> implements Sortable<T> {

    Sortable sortable;

    TimerSorter(Sortable sortable) {
        this.sortable = sortable;
    }

    @Override
    public void sort(T[] data) {
        StopWatch sw = new StopWatch();
        sw.start();
        if (this.sortable != null) {
            this.sortable.sort(data);
        }
        sw.stop();
        System.out.printf("time:%s%n", sw.getTotalTimeSeconds());
    }
}
