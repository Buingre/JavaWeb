package test.thread0522;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 执行了10次初始化方法，
 */
public class Demo7ThreadLocal实现一千个线程时间格式化 {
    //创建了并初始化ThreadLocal

    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal(){
        @Override
        protected SimpleDateFormat initialValue() {
            System.out.println("----------执行initialValue方法---------- ");

            return new SimpleDateFormat("mm:ss");
        }
    };
    public static void main(String[] args) {
        //线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                10,0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
        //执行任务。【一般要执行remove】
        for (int i = 1; i <1001 ; i++) {
            int finalI = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(finalI*1000);
                    myFormatTime(date);
                }
            });
        }
    }
    private static void myFormatTime(Date date) {
        String res = threadLocal.get().format(date);
        System.out.println("时间："+res);
    }
}
