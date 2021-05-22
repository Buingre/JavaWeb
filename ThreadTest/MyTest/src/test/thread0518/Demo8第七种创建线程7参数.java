package test.thread0518;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 【线程池的创建：】
 *   前六种不可控: 会导致 ①线程数量不可控-->OOM
 *                     ②工作任务队列不可控-->OOM（阻塞队列大小Integer.MAX_VALUE，可能会导致内存溢出OutOfMemory异常）
 *   线程池有两个重要的对象：线程，工作队列
 *
 * TODO:7.【主角】原始 的线程池创建方式-->ThreadPoolExecutor
 */
public class Demo8第七种创建线程7参数 {
    public static int count = 1;

    public static void main(String[] args) {

        //创建线程工厂的方式2
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("myThreadPool-"+(count++));
                return thread;
            }
        };

        //7个参数原始的创建线程池的方式Demo10

        //参数： 核心线程数量（线程池正常情况下的数量。正式员工数量）、
        //      最大线程数量（当有大量的任务时，可以创建的最多的线程数，不能小于核心线程数量。临时工的数量）
        //      存活的时间（临时工的存活时间）、
        //      时间单位
        //      任务队列【一定要设置初始容量】
        //      线程工厂【设置统一行为，如命名、优先级...】就算不设置，源码也会设置
        //      拒绝策略【jdk有四种，自己可以定义一个。总共5种】

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,2,60, TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(1),threadFactory);

        //执行任务
        for (int i = 0; i <3 ; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名："+Thread.currentThread().getName());
                }
            });
        }


    }
    public static void main2(String[] args) {

        //创建线程工厂的方式2
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("myThreadPool-"+(count++));
                return thread;
            }
        };

        //6个参数原始的创建线程池的方式

        //参数： 核心线程数量（线程池正常情况下的数量。正式员工数量）、
        //      最大线程数量（当有大量的任务时，可以创建的最多的线程数，不能小于核心线程数量。临时工的数量）
        //      存活的时间（临时工的存活时间）、
        //      时间单位
        //      任务队列【一定要设置初始容量】
        //      线程工厂【设置统一行为】

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,2,60, TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(1),threadFactory);

        //执行任务
        for (int i = 0; i <3 ; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名："+Thread.currentThread().getName());
                }
            });
        }


    }
    public static void main1(String[] args) {
        //5个参数原始的创建线程池的方式

        //参数： 核心线程数量（线程池正常情况下的数量。正式员工数量）、
        //      最大线程数量（当有大量的任务时，可以创建的最多的线程数，不能小于核心线程数量。临时工的数量）
        //      存活的时间（临时工的存活时间）、
        //      时间单位
        //      任务队列【一定要设置初始容量】

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(1));

        //执行任务
        for (int i = 0; i <3 ; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名："+Thread.currentThread().getName());
                }
            });
        }


    }
}
