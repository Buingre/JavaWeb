package test.thread0506;

import java.util.Date;

/**
 *  sleep不释放锁
 *  wait释放锁
 */
public class ThreadDemo42 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        System.out.println("t1 开始休眠");
                        Thread.sleep(5*1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 执行结束");

                }
            }
        },"t1");
        t1.start();


        //防止主线程先执行
        Thread.sleep(1000);
        //在t1休眠时  主线程尝试获取lock锁
        synchronized (lock){
            System.out.println("主线程获取到了lock锁");
        }
    }
}
