package com.lzwing.testcode.gist;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/5/21
 * Time: 17:14
 */
@Data
public class ComapreObj implements Comparable<ComapreObj> {
    private int priority;

    public ComapreObj(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(ComapreObj o) {
//        return this.priority - o.priority;
        if(this.getPriority() > o.getPriority()){
            return -1;
        }else if(this.getPriority() < o.getPriority()){
            return 1;
        }
        return 0;
    }
}
