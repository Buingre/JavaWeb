package thread0526多线程高阶;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用代码方式演示ABA问题
 */
public class Demo4_问题ABA {
    private static AtomicReference money =
            new AtomicReference(100);

    public static void main(String[] args) throws InterruptedException {
        // 转账 -100
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(100, 0);
                System.out.println("线程1执行转账：" + result);
            }
        });
        t1.start();
        t1.join();
        // 账户增加了 100---【导致异常的操作，公司突然给我发了100块】
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(0, 100);
                System.out.println("线程3转入100元：" + result);
            }
        });
        t3.start();
        t3.join();
        // 转账 -100
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(100, 0);
                System.out.println("线程2执行转账：" + result);
            }
        });
        t2.start();


    }
}
