package test.thread0518;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 【线程池的创建：】
 * 3.创建可以执行定时任务的线程池
 */
public class Demo4 {
    public static void main(String[] args) {
        //创建可以执行定时任务的线程池:
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        System.out.println("设置定时任务：" + new Date());
        //执行定时任务
        //执行方式1-----可以一直执行
        /*scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务: " + new Date());
            }
        }, 1, 3, TimeUnit.SECONDS);//线程执行的任务Runnable，延迟执行，执行频率3s，时间单位
*/

        //执行方式2----只会执行一次。。作用：延迟初始化
       /* scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务："+new Date());
            }
        },1,TimeUnit.SECONDS);//延迟执行，时间单位

        */

        //执行方式3---和第一个的参数一样.
        // TODO:【区别：】
        //    1.以上次任务的开始时间作为下一次任务的开始时间
        //    3.以上次任务的结束时间作为下一次任务的开始时间
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);//【区别：1的执行频率还是3，方式3 的执行频率+1s】
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务: "+new Date());
            }
        },1,3,TimeUnit.SECONDS);
    }

}
