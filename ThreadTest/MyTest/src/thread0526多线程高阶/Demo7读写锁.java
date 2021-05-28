package thread0526多线程高阶;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo7读写锁 {
    public static void main(String[] args) {
        //创建一个读写锁
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        // 得到读锁
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        // 写锁
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 10, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));

        // 任务一：读锁演示
        executor.execute(new Runnable() {
            @Override
            public void run() {
                // 加锁
                readLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() +
                            " 进入了读锁，时间：" + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    readLock.unlock();
                }
            }
        });

        // 任务二：读锁演示
        executor.execute(new Runnable() {
            @Override
            public void run() {
                // 加锁
                readLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() +
                            " 进入了读锁，时间：" + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    readLock.unlock();
                }
            }
        });
        // 任务三：写锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() +
                            " 执行了写锁，时间：" + new Date());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }
        });
        // 任务四：写锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() +
                            " 执行了写锁，时间：" + new Date());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }
        });

    }
}
