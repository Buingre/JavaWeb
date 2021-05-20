package test.thread0518;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 【线程池的创建：】
 * 6.【JDK8+】创建异步线程: 根据当前的硬件CPU生成对应个数的线程池，并且是异步执行。
 *            【TODO:最大生成】
 */
public class Demo7 {
    public static void main(String[] args) {
        //根据当前的硬件CPU生成对应个数的线程池，并且是异步执行
         ExecutorService executorService =Executors.newWorkStealingPool();
         //执行任务
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名称："+ Thread.currentThread().getName());
                }
            });
        }//直接执行完 没有打印

        while (!executorService.isTerminated()){ }//等待线程池执行完成


    }
}
