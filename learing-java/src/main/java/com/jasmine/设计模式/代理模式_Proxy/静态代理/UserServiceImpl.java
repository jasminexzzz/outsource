package com.jasmine.设计模式.代理模式_Proxy.静态代理;

/**
 * service实现类
 * @author : jasmineXz
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("UserServiceImpl保存了一个用户");
    }
}
