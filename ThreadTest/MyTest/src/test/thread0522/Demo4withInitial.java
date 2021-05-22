package test.thread0522;

import java.util.Date;
import java.util.function.Supplier;

/**
 * withInitial():
 *        两个线程 执行了2次初始化方法
 */
public class Demo4withInitial {
    //创建了并初始化ThreadLocal
    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(new Supplier<String>() {
        @Override
        public String get() {
            System.out.println("执行了withInitial方法");

            return Thread.currentThread().getName()+" java";
        }
    });
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String result = threadLocal.get();
                System.out.println(Thread.currentThread().getName()+" 获取到的内容： "+result);
            }
        };
        //使用线程的方式演示。线程池也一样
        Thread t1 = new Thread(runnable," 线程1");
        t1.start();


        Thread t2 = new Thread(runnable," 线程2");
        t2.start();
    }
}
