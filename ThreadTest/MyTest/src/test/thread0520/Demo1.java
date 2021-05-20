package test.thread0520;

import org.omg.CORBA.DATA_CONVERSION;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实现两个线程的时间格式化
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(1000);
                myFormatTime(date);
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(2*1000);
                myFormatTime(date);
            }
        });
        t2.start();

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
