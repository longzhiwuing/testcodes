package com.lzwing.demo.test.beanorder;

import java.util.Observable;
import java.util.Observer;

// 观察者：它会观察主人，只要放鱼了它就会去吃（消费）
public class Cat implements Observer {

    public String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        String masterName = o.toString();
        // 因为该观察者接口没有泛型 所以只能强转
        if (o instanceof Master) {
            masterName = ((Master) o).name;
        }
        System.out.println(name + "吃了主人" + masterName + "放的鱼");
    }
}