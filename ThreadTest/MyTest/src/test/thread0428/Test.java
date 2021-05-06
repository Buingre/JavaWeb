package test.thread0428;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  使用公平锁  实现打印AABBCCDD
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock(true);//公平锁
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (char i:"ABCD".toCharArray() ) {
                    lock.lock();
                    try{
                        System.out.print(i);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread.sleep(100);//休眠等待大家都完成初始化
        t1.start();
        t2.start();
    }
}
