package com.lzwing.testcode.gof23.observable;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/9/16
 * Time: 11:03
 */
@Slf4j
public class ListenerB implements Observer {

    Observable observable;

    public ListenerB(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Topic) {
            Topic topic = (Topic) o;
            log.info("get info:{}", topic.getMsg());
        }
    }
}
