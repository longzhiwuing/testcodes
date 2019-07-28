package com.lzwing.testcode.thread.stampedlock;

import java.util.concurrent.locks.StampedLock;

/**
 * Created with IntelliJ IDEA.
 *
 *
 * stamplock例子
 *
 * @author: chenzhongyong
 * Date: 2019/7/27
 * Time: 21:37
 */
public class Point {
    private double x,y;

    private final StampedLock sl = new StampedLock();

    void move(double deltaX, double deltaY) {
        //使用写锁-独占操作
        long stamp = sl.writeLock();
        try {
            x = deltaX;
            y = deltaY;
        }finally {
            sl.unlockWrite(stamp);
        }
    }

    double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead();
        double currentX = x, currentY = y;
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            }finally {
                sl.unlockWrite(stamp);
            }
        }

        return Math.sqrt(currentX * currentX + currentY + currentY);
    }
}
