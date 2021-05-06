package test.thread0424;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程的创建方式三：Callable+FutureTask
 *          可以接受线程执行之后的返回值
 * 【3常用】
 */
public class ThreadDemo8 {
    static class MyCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            //产生随机数
            int num = new Random().nextInt(10);
            System.out.println(String.format("线程：%s，生产随机数：%d",Thread.currentThread().getName(),num));
            return num;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.创建 Callable 子对象
        MyCallable myCallable = new MyCallable();
        //2.使用 FutrueTask 接收 Callable
        //一个容器而已
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        //3.创建线程并设置任务
        Thread thread = new Thread(futureTask);
        //执行线程
        thread.start();
        //得到线程的执行结果
        int num = futureTask.get();
        System.out.println("线程返回结果："+num);
    }
}
