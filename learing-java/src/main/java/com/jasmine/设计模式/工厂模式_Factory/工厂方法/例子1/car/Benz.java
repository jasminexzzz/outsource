package com.jasmine.设计模式.工厂模式_Factory.工厂方法.例子1.car;

/**
 * @author : jasmineXz
 */
public class Benz implements Car {
    @Override
    public void build() {
        System.out.println("造了一辆:"+this.getClass().getSimpleName());
    }
}
