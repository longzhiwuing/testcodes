package com.lzwing.demo.test.beanorder;

import java.util.Observable;

// 主人：最终会有小动物观察主人
// 主人有个能力：放鱼
public class Master extends Observable {

    public String name;

    private Master(String name) {
        this.name = name;
    }

    // 给鱼：然后通知所有的观察者过来吃鱼。这样所有观察的猫都会过来了
    public void giveFish() {
        System.out.println(name + "主人放了一条鱼，通知猫过来吃~~~~~~");
        setChanged(); // 这个一定不能忘
        notifyObservers();
    }

    // 单例
    private static final Master MASTER = new Master("YoutBatman");

    public static Master getMaster() {
        return MASTER;
    }
}