package test.thread0518;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 【线程池的创建：7种方法，两种方式:Executors、】
 * 1.创建一个固定个数的线程池
 *
 * 3.创建可以执行定时任务的线程池
 * 4.
 **/
public class Demo1 {
    public static void main(String[] args) {
        //创建一个固定个数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);//最多创建10
        //执行任务
        for (int i = 0; i <2 ; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名称："+ Thread.currentThread().getName());//pool-1-thread-1
                }
            });
        }

        /*executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名称："+ Thread.currentThread().getName());//pool-1-thread-2
            }
        });*/



    }
}
