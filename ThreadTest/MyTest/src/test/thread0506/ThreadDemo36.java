package test.thread0506;

import java.util.concurrent.TimeUnit;

/**
 * 死锁实例
 */
public class ThreadDemo36 {
    public static void main(String[] args) {
        //声明（加锁的）资源
        Object lockA = new Object();
        Object lockB = new Object();

        //创建线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                synchronized (lockA) {
                    //已经获取到lockA
                    System.out.println(threadName + " Get lockA.");
                    //休眠1秒, 让t2获取lockB

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(threadName+" Wating lockB...");
                    synchronized (lockB){
                        //已经获取到lockB
                        System.out.println(threadName+" Get lockB.");
                    }
                }
            }
        },"t1");
        t1.start();

        //创建线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                //1.获取资源B（lockB）
                synchronized (lockB) {
                    System.out.println(threadName + " Get lockB.");
                //}todo:这里的大括号就不构成死锁：【已解决】因为造成死锁的原因就是因为当线程1拥有资源1并且尝试获取资源2＆＆线程2拥有资源2并且试图获取资源1的时候，就会出现死锁
                    //2.休眠1s----》让t1先获取到lockA
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName+" Wating lockA...");

                    //3.获取资源A（lockA）
                    synchronized (lockA){
                        //已经获取到lock
                        System.out.println(threadName+" Get lockA.");
                    }
                }

            }
        },"t2");
        t2.start();

    }
}
