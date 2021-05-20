package test.thread0520;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程安全的解决方案：【使用私有变量】【加锁】
 *                todo:【ThreadLocal线程的本地变量:1000个任务，10个线程池的示例来说，使用ThreadLocal就是创建10 Simple】
 */
public class Demo4 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
        for (int i = 1; i < 1001; i++) {
            final int finalI = i;

            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(finalI * 1000);
                    myFormatTime(date);
                }
            });

        }
    }

    /**
     * 时间格式化方法
     * @param date
     */
    private static void myFormatTime(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

        String res = simpleDateFormat.format(date);
        System.out.println(Thread.currentThread().getName()+" , 格式化时间："+res);
    }
}
