package test.thread0426;

/**
 * 【多线程不安全问题】-----》多线程示例
 * todo:4、28  【两个demo的区别】
 */
public class ThreadDemo26 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(()->{
            counter.increment();
        });
        t1.start();

        Thread t2 = new Thread(()->{
            counter.decrement();
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println("最终执行结果："+counter.getCount());//每次执行结果不一样

    }
}
