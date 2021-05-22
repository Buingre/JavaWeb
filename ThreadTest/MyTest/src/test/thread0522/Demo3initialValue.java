package test.thread0522;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal是线程级别的方法，一个线程只执行一次初始化
 */
public class Demo3initialValue {
    //创建了并初始化ThreadLocal
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            int num = new Random().nextInt(10);
            System.out.println("执行initialValue方法,生成了 "+num);

            return num;
        }
    };
    public static void main(String[] args) {
        //创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                1,0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
        //执行任务
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                //get ThreadLocal
                int res = threadLocal.get();
                System.out.println(Thread.currentThread().getName()+" 得到结果1 "+res);
            }
        });

        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                //get ThreadLocal
                int res = threadLocal.get();
                System.out.println(Thread.currentThread().getName()+" 得到结果2 "+res);
            }
        });
    }
}
