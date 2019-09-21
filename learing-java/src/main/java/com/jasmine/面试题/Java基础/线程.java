package Java基础;

import org.junit.Test;

/**
 * @author : jasmineXz
 */
public class 线程 {
    class runnable implements Runnable{
        private String name;
        public runnable(String name){
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(name);
        }
    }

    /**
     1. 现在有线程 T1、T2 和 T3。你如何确保 T2 线程在 T1 之后执行，并且 T3 线程在 T2 之后执行？
        可以用 Thread 类的 join 方法实现这一效果。
     */
    @Test
    public void testJoin(){
        Thread t1 = new Thread(new runnable("t1"));
        Thread t2 = new Thread(new runnable("t2"));
        Thread t3 = new Thread(new runnable("t3"));
        try {
            t3.start();
            t3.join();
            t2.start();
            t2.join();
            t1.start();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     2. Java 中新的 Lock 接口相对于同步代码块（synchronized block）有什么优势？
        ───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        1.首先synchronized是java内置关键字，在jvm层面，Lock是个java类；
        2.synchronized无法判断是否获取锁的状态，Lock可以判断是否获取到锁；
        3.synchronized会自动释放锁(a 线程执行完同步代码会释放锁 ；b 线程执行过程中发生异常会释放锁)，Lock需在finally中手工释放锁（unlock()方
          法释放锁），否则容易造成线程死锁；
        4.用synchronized关键字的两个线程1和线程2，如果当前线程1获得锁，线程2线程等待。如果线程1阻塞，线程2则会一直等待下去，而Lock锁就不一定会
          等待下去，如果尝试获取不到锁，线程可以不用一直等待就结束了；
        5.synchronized的锁可重入、不可中断、非公平，而Lock锁可重入、可判断、可公平（两者皆可）
        6.Lock锁适合大量同步的代码的同步问题，synchronized锁适合代码少量的同步问题。


     3. 如果让你实现一个高性能缓存，支持并发读取和单一写入，你如何保证数据完整性。
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        多线程和并发编程中使用 lock 接口的最大优势是它为读和写提供两个单独的锁，可以让你构建高性能数据结构，
        比如 ReadWriteLock和ConcurrentHashMap都可以构建.
        这道 Java 线程面试题越来越多见，而且随后的面试题都基于面试者对这道题的回答。
        我强烈建议在任何 Java 多线程面试前都要多看看有关锁的知识，因为如今电子交易系统的客户端和数据交互中，锁被频繁使用来构建缓存。

     4. ReadWriteLock和ConcurrentHashMap的选择
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        @link https://blog.csdn.net/justloveyou_/article/details/72783008
        从简化编程来看,应该用ConcurrentHashMap
        ReadWriteLock适用于读线程远远多于写线程的情况下，而且一般是有写的情况下读会阻塞——这样下来甚至还不如一般的锁。
        从性能来看，同样应该用ConcurrentHashMap,因为它内部已经对读写操作进行了分块优化，在大多数情况下，读写可以同时进行。你自己很难实现得更加
        高效。

     5. Java 中 wait 和 sleep 方法有什么区别？
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        sleep和wait都会释放cpu资源
        wait  : 线程会释放监视器,被notify后将继续争抢CPU资源,抢到后执行
        sleep : 线程不会释放锁,继续占有锁等睡眠完成后继续执行

     6. 既然 start() 方法会调用 run() 方法，为什么我们调用 start() 方法，而不直接调用 run() 方法？
        当你调用 start() 方法时，它会新建一个线程然后执行 run() 方法中的代码。
        如果直接调用 run() 方法，并不会创建新线程，方法中的代码会在当前调用者的线程中执行。

     6. 如何在java中实现一个阻塞队列
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        @link https://blog.csdn.net/chonganwang/article/details/84287961
        @link https://www.cnblogs.com/tjudzj/p/4454490.html
        和上面有关线程的问题相似，这个问题在工作中很典型，但有时面试官会问这类问题，比如“在 Java 中如何解决生产者消费者问题？”其实，有很多解决方
        式。我分享过用 Java 中 BlockingQueue 的解决方案。


     7. 如何在 Java 中编写代码解决生产者消费者问题？答案
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        @see com.jasmine.JavaBase.C_线程.线程同步.阻塞队列.生产者和消费者的问题
        和上面有关线程的问题相似，这个问题在工作中很典型，但有时面试官会问这类问题，比如“在 Java 中如何解决生产者消费者问题？”其实，有很多解决方
        式

     8. 线程锁死,如何解决锁死
        @see com.jasmine.JavaBase.C_线程.线程同步.线程卡死.DeadLock
        @link https://www.cnblogs.com/xiaoxi/p/8311034.html

     9. 什么是原子性?
        什么是原子操作？
        Java中有哪些原子操作？
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        原子性 : 要么完整执行,要么完全不执行.
        原子操作 : 所谓原子操作是不会被线程调度机制打断的操作，这种操作一旦开始就不会结束，中间不会有任何操作，也不会进行线程的切换。
        Java中的原子操作 : atomic包下的类
        紧着着可能会问 : 你需要同步原子操作吗？

     10. Java 中 volatile 关键字是什么？你如何使用它？它和 Java 中的同步方法有什么区别？
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        @see com.jasmine.JavaBase.C_线程.volatile关键字.概念
        线程执行时会把变量从主内存拷贝到CPU缓存中,如果多个线程操作同一个变量,就会出现数据错误的情况,volatile保证了每一次操作都从缓存中获取.
        volatile保证了可见性,但不能保证原子性.也就是每次操作被volatile操作的变量时,其他线程都是可以实时观察到变量的变化.

     11. 什么是CAS操作?
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        @see https://blog.csdn.net/Hsuxu/article/details/9467651
        CompareAndSwap的缩写，中文意思是：比较并替换。
        CAS需要有3个操作数：内存地址V，旧的预期值A，即将要更新的目标值B。
        当且仅当内存地址V的值与预期值A相等时，将内存地址V的值修改为B，否则就什么都不做。整个比较并替换的操作是一个原子操作。

     12. 什么是ABA问题,怎么解决?
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        如果内存地址V初次读取的值是A，并且在准备赋值的时候检查到它的值仍然为A，那我们就能说它的值没有被其他线程改变过了吗？
        如果在这段期间它的值曾经被改成了B，后来又被改回为A，那CAS操作就会误认为它从来没有被改变过。这个漏洞称为CAS操作的“ABA”问题。
        Java中提供了AtomicStampedReference和AtomicMarkableReference来解决ABA问题。

     13. 什么是竞态条件？你如何发现并解决竞态条件？
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        指的是并发复合操作,结果不可预测问题。
        if(a == 10.0){
            b = a / 2.0;
        }
        例如线程1检查a的值,检查正确但为执行时,线程2修改了a的值,此时线程1执行时,结果就会错误.其实就是线程同步的问题.

     14. 什么是数据竞争?
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        指的是并发条件下,状态属性信息不同步,产生读写误差。
        最典型的是单例模式常见的问题.
        private static Parser parser;
        public static Parser getInstance(){
            if(parser == null)
                parser = new Parser();
            return parser;
        }

     16. Java 中你如何唤醒阻塞线程？
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        线程阻塞的原因有很多,需要分开回答.
        如果是IO阻塞,则没法办中断.
        如果是由于调用了wait(),sleep(),join()方法,你可以中断线程，通过抛出 InterruptedException 异常来唤醒该线程。

     17. 你在多线程环境中遇到的最多的问题是什么？你如何解决的？

     18. 什么是不可变类？它对于编写并发应用有何帮助？
        ──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
        类中的所有类变量都被final修饰.
        没有修改变量的方法.如set方法
        所有方法都被fianl修饰.

        线程安全.
        易于设计.
        如String,和Integer类,想要像基本类型一样使用,就要设计成不可变类.

     */




























































}
