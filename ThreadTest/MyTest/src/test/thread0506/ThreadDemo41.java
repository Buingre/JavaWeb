package test.thread0506;

import java.util.Date;

/**
 * wait方法：三个呢
 *     wait(2000);
 */
public class ThreadDemo41 {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("t1 进入wait 状态："+new Date());
                    try {
                        lock.wait(360*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 代码执行完成:"+new Date());

                }
            }
        },"t1");
        t1.start();
    }
}
