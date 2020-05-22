package com.jasmine.设计模式;

/**
 * @author : jasmineXz
 */
public class 总结 {
    /**
     一. 设计模式的类型
        1. 创建型模式：
            单例模式:
            @see com.jasmine.设计模式.单例模式_Singleton.概念
            建造者模式
            @see com.jasmine.设计模式.建造者模式_builder.例2.UserBuilder
            工厂模式:
            @see com.jasmine.设计模式.工厂模式_Factory.概念
            抽象工厂模式
            @see com.jasmine.设计模式.工厂模式_Factory.抽象工厂
            原型模式
            克隆模式,深拷贝浅拷贝实现

        2. 结构型模式:
            适配器模式
            @see com.jasmine.设计模式.适配器模式_Adapter.概念
            装饰器模式:
            @see com.jasmine.设计模式.装饰器模式_Decorator.概念.md
            桥接模式
            组合模式
            外观模式
            享元模式
            代理模式:
            @see com.jasmine.设计模式.代理模式_Proxy.概念

        3. 行为型模式：
            模版方法模式
            @see com.jasmine.设计模式.模板模式_Template.概念
            命令模式
            迭代器模式
            观察者模式
            中介者模式
            备忘录模式
            解释器模式
            状态模式
            策略模式
            @see com.jasmine.设计模式.策略模式_Strategy
            职责链模式
            访问者模式

     二. 设计模式的六大原则
        1. 单一值则原则 (Single Responsibility Principle, SRP) :
            1). 一个类只承担一个职责,即我们要修改一个类时,要因为一个且只会因为一个原因而去修改它,例如我需要修改用户类,必定是因为
                用户属性发生了变化去修改,而不是因为部门发生变化,或者角色发生变化而去修改用户类.

        2. 开闭原则 (Open-Closed Principle, OCP) :
            1). 一个软件实体应当对扩展开放，对修改关闭。即软件实体应尽量在不修改原有代码的情况下进行扩展。
            2). 软件实体可以指一个软件模块、一个由多个类组成的局部结构或一个独立的类。
            3). 抽象化是开闭原则的关键

        3. 里氏替换原则 (Liskov Substitution Principle, LSP) :
            1). 在软件中将一个基类对象替换成它的子类对象，程序将不会产生任何错误和异常，反过来则不成立，如
                果一个软件实体使用的是一个子类对象的话，那么它不一定能够使用基类对象。
            2). 在程序中尽量使用基类类型来对对象进行定义，而在运行时再确定其子类类型，用子类对象来替换父类对象。
            3). 里氏代换原则是实现开闭原则的重要方式之一.

        4. 依赖倒置原则 (Dependency Inversion  Principle, DIP) :
            1). 抽象不应该依赖于细节，细节应当依赖于抽象。换言之，要针对接口编程，而不是针对实现编程。
            2). 开闭原则是目标，里氏代换原则是基础，依赖倒置原则是手段.

        5. 接口隔离原则 (Interface  Segregation Principle, ISP) :
            1). 使用多个专门的接口，而不使用单一的总接口，即客户端不应该依赖那些它不需要的接口。
            2). 每一个接口应该承担一种相对独立的角色，不干不该干的事，该干的事都要干。
            3). 接口仅仅提供客户端需要的行为，客户端不需要的行为则隐藏起来，应当为客户端提供尽可能小的单独的接口，而不要提供大的总接口。
            4). 在使用接口隔离原则时，我们需要注意控制接口的粒度，接口不能太小，如果太小会导致系统中接口泛滥，不利于维护；接口也不能太
                大，太大的接口将违背接口隔离原则，灵活性较差，使用起来很不方便

        6. 迪米特法则 (Law of Demeter, LoD) :
            1). 一个软件实体应当尽可能少地与其他实体发生相互作用。
            2). 迪米特法则可降低系统的耦合度，使类与类之间保持松散的耦合关系。
            3). 应该尽量减少对象之间的交互，如果两个对象之间不必彼此直接通信，那么这两个对象就不应当发生任何直接的相互作用，如果其中的
                一个对象需要调用另一个对象的某一个方法的话，可以通过第三者转发这个调用。简言之，就是通过引入一个合理的第三者来降低现有
                对象之间的耦合度。

     三. 容易混淆的模式
        1. 代理模式 / 策略模式 / 装饰器模式
            1). 代理模式
            2). 策略模式
            3). 装饰器模式

































     */
}
