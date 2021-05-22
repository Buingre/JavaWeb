package test.thread0520;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  *  * 实现1000个线程的时间格式化----------->使用线程池
 */
public class Demo3一千个线程的时间格式化 {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
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
    private synchronized static void myFormatTime(Date date){
        String res = simpleDateFormat.format(date);
        System.out.println(Thread.currentThread().getName()+" , 格式化时间："+res);
    }
}
