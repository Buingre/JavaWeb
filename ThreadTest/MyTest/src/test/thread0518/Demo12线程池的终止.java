package test.thread0518;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的终止
 */
public class Demo12线程池的终止 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5,5,60,
                        TimeUnit.SECONDS,new LinkedBlockingDeque<>(10));

        for (int i = 0; i < 15; i++) {
            final int finalI = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI+"  线程名："+Thread.currentThread().getName());

                }
            });
        }

        //结束线程池
        threadPoolExecutor.shutdown();//执行完15个
//        threadPoolExecutor.shutdownNow();//立即终止线程池，线程池的任务不会执行完，么有执行完15个

    }
}
