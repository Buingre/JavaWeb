package thread0526多线程高阶;

import java.util.concurrent.atomic.AtomicStampedReference;

public class Demo5_解决ABA {
    private static AtomicStampedReference money =
            new AtomicStampedReference(100, 1);

    public static void main(String[] args) throws InterruptedException {
        // 转账 -100
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(100, 0,
                        1, 2);
                System.out.println("线程1执行转账：" + result);
            }
        });
        t1.start();
        t1.join();
        // 账户增加了 100
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(0, 100,
                        2, 3);
                System.out.println("线程3转入100元：" + result);
            }
        });
        t3.start();
        t3.join();
        // 转账 -100
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(100, 0,
                        1, 2);//因为是同时按了两次转账按钮，所以这里的条件一样
                System.out.println("线程2执行转账：" + result);
            }
        });
        t2.start();


    }
}
