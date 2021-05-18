package test.thread0518;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;//JUC==ava.util.concurrent 所有的并发类在这个包下

/**
 *  * 【线程池的创建：7种】
 *  * 1.创建固定个数的线程池 Demo1
 *  * 2.创建带缓存的线程池  Demo2 --- 当有短期大量任务时: 根据当前任务多少创建
 *
 */
public class Demo2 {
    public static void main(String[] args) {
        //创建带缓存的线程池
        ExecutorService executorService =  Executors.newCachedThreadPool();
        for (int i = 0; i <100 ; i++) {//【】
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名称："+ Thread.currentThread().getName());
                }
            });
        }
    }
}
