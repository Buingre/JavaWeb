package thread0526多线程高阶;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 【只修改Demo5的金额】
 */
public class Demo6 {
    private static AtomicStampedReference money =
            new AtomicStampedReference(1000, 1);

    public static void main(String[] args) throws InterruptedException {


        // 转账 -1000
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(1000, 0,
                        1, 2);
                System.out.println("线程1执行转账：" + result);
            }
        });
        t1.start();

        t1.join();

        // 账户增加了 1000
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(0,
                        1000,
                        2, 3);
                System.out.println("线程3转入1000元：" + result);
            }
        });
        t3.start();


        t3.join();

        // 转账 -100
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(1000,
                        0,
                        1, 2);
                System.out.println("线程2执行转账：" + result);
            }
        });
        t2.start();


    }
}
