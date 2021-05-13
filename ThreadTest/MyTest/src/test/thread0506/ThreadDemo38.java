package test.thread0506;

/**
 * 线程通讯
 *    单线程的休眠和唤醒
 */
public class ThreadDemo38 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        System.out.println("wait 之前");
                        //【必须先加锁：】
                        lock.wait();
                        System.out.println("wait 之后");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        },"t1");
        t1.start();

        Thread.sleep(500);
        System.out.println("主线程唤醒t1");
        //在主线程中唤醒线程t1
        //【唤醒操作之前也要加锁】
        synchronized (lock){
            //lock.notify();
            lock.notifyAll();
        }

    }
}
