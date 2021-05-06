package test.thread0428;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 【Lock】
 */
public class ThreadDemo34 {
    //循环次数
    private static  final int maxSize = 100000;
    //全局遍历
    private static volatile int number = 0;
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo34 threadDemo34 = new ThreadDemo34();
        //【1.创建Lock实例】
        Lock lock = new ReentrantLock();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <maxSize ; i++) {
                    //【2.加锁:核心代码上加锁。一定要在try外边】
                    lock.lock();
                    try{
                        number++;
                    }finally {
                        //【3.释放锁：要在finally里边】
                        lock.unlock();
                    }

                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <maxSize ; i++) {
                    lock.lock();
                    try{
                        number--;
                    }finally {
                        lock.unlock();
                    }


                }
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println("最终结果："+number);//0

    }
}
