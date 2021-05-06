package test.thread0428;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示Lock锁  写在try里边
 */
public class ThreadDemo35 {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock(true);
        lock.lock();
        try {
            int num = 1 / 0;
        } finally {
            lock.unlock();
        }

    }
}
