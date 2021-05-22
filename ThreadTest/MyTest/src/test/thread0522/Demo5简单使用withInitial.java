package test.thread0522;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * withInitial()的简单使用方法:Lambda方法
 */
public class Demo5简单使用withInitial {
    //创建了并初始化ThreadLocal
    private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->"java");
    public static void main(String[] args) {
        //使用线程池的方法演示
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                1,0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
        //执行任务
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                //get ThreadLocal
                String res = threadLocal.get();
                System.out.println(Thread.currentThread().getName()+" 得到结果 "+res);
            }
        });
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                //get ThreadLocal
                String res = threadLocal.get();
                System.out.println(Thread.currentThread().getName()+" 得到结果 "+res);
            }
        });
    }
}
