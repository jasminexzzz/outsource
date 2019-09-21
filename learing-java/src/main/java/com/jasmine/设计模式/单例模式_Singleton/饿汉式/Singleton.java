package com.jasmine.设计模式.单例模式_Singleton.饿汉式;

/**
 * 饿汉式单例
 * @author : jasmineXz
 */
public class Singleton {
    // 私有构造
    private Singleton() {}

    private static Singleton single = new Singleton();

    public static Singleton getInstance() {
        return single;
    }
}
