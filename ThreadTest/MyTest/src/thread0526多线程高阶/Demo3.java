package thread0526多线程高阶;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * 实现i++、i--保证线程安全
 *
 * 【此版本安全】
 */
public class Demo3 {
    private static AtomicInteger count= new AtomicInteger(0);
    private static final int MAXSIZE = 100000;//最大循环次数
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXSIZE ; i++) {
                    count.getAndIncrement(); // i++
//                    count.incrementAndGet(); // ++i
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXSIZE ; i++) {
                    count.getAndDecrement();// i--
                }
            }
        });
        t2.start();
        t1.join();
        t2.join();
//        int res= count.getAndIncrement();
//        count.incrementAndGet();
        System.out.println("最终结果："+count.get());
    }
}
