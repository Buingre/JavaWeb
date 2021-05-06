package test.thread0428;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示公平锁和非公平锁
 */
public class ThreadDemo36 {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock(true);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    lock.lock();
                    try{
                        System.out.println("线程1");
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    lock.lock();
                    try{
                        System.out.println("线程2");
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });
        Thread.sleep(100);
        t1.start();
        t2.start();

    }
}
