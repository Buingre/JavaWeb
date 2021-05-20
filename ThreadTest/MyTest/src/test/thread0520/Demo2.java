package test.thread0520;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  * 实现10个线程的时间格式化
 */
public class Demo2 {
    public static void main(String[] args) {
        for (int i = 1; i <11 ; i++) {
            int finalI = i;
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(finalI * 1000);
                    myFormatTime(date);
                }
            });
            t1.start();
        }
    }

    /**
     * 时间格式化方法
     * @param date
     */
    private static void myFormatTime(Date date){
        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
        String res = format.format(date);
        System.out.println(Thread.currentThread().getName()+" , 格式化时间："+res);
    }
}
