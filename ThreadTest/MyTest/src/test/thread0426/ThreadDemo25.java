package test.thread0426;

/**
 * 【多线程不安全问题】----》单线程示例
 */
public class ThreadDemo25 {
    public static void main(String[] args) {
        //单线程示例
        Counter counter = new Counter();
        counter.increment();
        counter.decrement();
        System.out.println("最终执行结果："+counter.getCount());//最终执行结果：0


    }
}
