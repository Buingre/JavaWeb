package thread0526多线程高阶;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现i++、i--保证线程安全
 *
 * 【此版本不安全】
 */
public class Demo2_Automic保证线程安全 {

    private static int count = 0;
    private static final int MAXSIZE = 100000;//最大循环次数
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXSIZE ; i++) {
                    count++;
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXSIZE ; i++) {
                    count--;
                }
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println("最终结果："+count);
    }
}
