package com.lzwing.testcode.gof23.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/7/11
 * Time: 17:49
 *
 * idea 自带单利方式 饿汉模式
 */
public class IdeaSingleton {
    private static IdeaSingleton ourInstance = new IdeaSingleton();

    public static IdeaSingleton getInstance() {
        return ourInstance;
    }

    private IdeaSingleton() {
    }
}
