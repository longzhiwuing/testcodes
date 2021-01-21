package com.lzwing.testcode.datastructor.sort;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/25
 * Time: 22:37
 */
@Slf4j
public class TimerSorter<T> implements Sortable<T> {

    Sortable sortable;

    TimerSorter(Sortable sortable) {
        this.sortable = sortable;
    }

    @Override
    public void sort(T[] data) {
        log.info("before:{}", data.length);
        log.info(Arrays.toString(data));
        StopWatch sw = new StopWatch();
        sw.start();
        if (this.sortable != null) {
            this.sortable.sort(data);
        }
        sw.stop();
        log.info("time:{}", sw.getTotalTimeSeconds());
        log.info("after:{}", data.length);
        log.info(Arrays.toString(data));
    }
}
