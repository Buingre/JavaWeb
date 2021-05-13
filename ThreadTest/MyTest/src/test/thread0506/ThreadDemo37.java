package test.thread0506;

import java.util.concurrent.TimeUnit;

/**
 * 解决死锁-------------》环路等待条件
 */
public class ThreadDemo37 {
    public static void main(String[] args) {
        //声明（加锁的）资源
        Object lockA = new Object();
        Object lockB = new Object();

        //创建线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                synchronized (lockA){
                    //已经获取到lockA
                    System.out.println(threadName+" Get lockA.");
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
                //1.获取资源A
                synchronized (lockA){
                    System.out.println(threadName+" Get lockA.");
                    //2.休眠1s
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName+" Wating lockB...");

                    //3.获取资源B
                    synchronized (lockB){
                        //已经获取到lockB
                        System.out.println(threadName+" Get lockB.");
                    }
                }

            }
        },"t2");
        t2.start();

    }
}

