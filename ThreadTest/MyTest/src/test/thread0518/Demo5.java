package test.thread0518;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 【线程池的创建：】
 * 4.创建单个线程来执行定时任务
 */
public class Demo5 {
    public static void main(String[] args) {
        //创建单个线程来执行定时任务
        //等价于ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
         ScheduledExecutorService service =Executors.newSingleThreadScheduledExecutor();
         //执行任务 同3的
         service.scheduleWithFixedDelay(new Runnable() {
             @Override
             public void run() {
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println("执行任务："+new Date());
             }
         },1,3, TimeUnit.SECONDS);
    }
}
