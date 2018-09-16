package com.lzwing.testcode.gof23.observable;

import lombok.Data;

import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/9/16
 * Time: 11:00
 */
@Data
public class Topic extends Observable {

    private String msg;

    public void makeMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }

    public static void main(String[] args) {
        Topic topic = new Topic();

        /*topic.addObserver(new ListenerA());
        topic.addObserver(new ListenerB());*/

        new ListenerA(topic);
        new ListenerB(topic);

        topic.makeMsg("hello,world!");

        topic.makeMsg("hello,observale");
    }


}
