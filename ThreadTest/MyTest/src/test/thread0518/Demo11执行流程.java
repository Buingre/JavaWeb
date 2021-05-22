package test.thread0518;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor 的执行流程
 *      核心线程数、最大线程数、任务队列
 *
 *      当任务量<核心线程数：他会创建一个线程来执行此任务
 *      当任务量>核心线程数  && 没有空闲线程 && 当前线程数<最大线程数：此时会将任务存到任务队列里边【因为把多出来的任务存储在任务队列的成本最小】
 *      当当前任务量比较大的时候，此时没有空闲的线程 && 任务队列已满 ：此时会判断当前线程池的任务数量是否>=最大线程数，
 *                                                             如果当前线程池的数量<最大线程数，创建线程来执行任务
 *                                                                当前线程池的数量=最大线程数 && 任务队列已满，此时会执行拒绝策略
 *
 */
public class Demo11执行流程 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5,5,60,
                        TimeUnit.SECONDS,new LinkedBlockingDeque<>(10));

        for (int i = 0; i < 20; i++) {
            final int finalI = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI+"  线程名："+Thread.currentThread().getName());

                }
            });
            Thread.sleep(100);//有时间复用线程
        }


    }
}
