package com.jasmine.设计模式.策略模式_Strategy.通用实现;

public class ConcreteStrategy implements IStrategy {
      //具体的算法实现
    @Override
    public void algorithmMethod() {
        System.out.println("ConcreteStrategy method...");
    }
}