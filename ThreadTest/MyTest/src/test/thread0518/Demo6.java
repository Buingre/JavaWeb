package test.thread0518;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 【线程池的创建：】
 * 5.创建单个线程的线程池
 * TODO:【创建单个线程的线程池意义：】
 *      1.可以避免频繁创建和销毁线程带来的性能开销
 *      2.有任务队列可以存储多余的任务
 *      3.当有大量的任务不能处理时可以友好的执行拒绝策略。
 *      4.单个线程池可以更好地管理任务
 */
public class Demo6 {
    public static void main(String[] args) {
        //创建单个线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //执行任务
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名称："+ Thread.currentThread().getName()+" , I :"+finalI);
                }
            });
        }


    }
}
