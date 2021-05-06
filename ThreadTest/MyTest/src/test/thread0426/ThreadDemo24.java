package test.thread0426;

/**
 * 【yield：让出CPU的执行权】
 */
public class ThreadDemo24 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                //出让CPU执行权
                Thread.yield();
                System.out.println("我是线程1");
            }
        });
        t1.start();

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("我是线程2");
            }
        });
        t2.start();
    }
}
