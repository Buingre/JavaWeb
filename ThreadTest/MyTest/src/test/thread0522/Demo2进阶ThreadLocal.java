package test.thread0522;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ThreadLocal高级用法之----------initialValue
 *                            创建ThreadLocal设置默认值
 *
 *                            执行了两次 initialValue方法，因为有两个线程
 */
public class Demo2进阶ThreadLocal {
    //创建并初始化 ThreadLocal
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal(){
        @Override
        protected SimpleDateFormat initialValue() {
            System.out.println("执行initialValue方法");
            return new SimpleDateFormat("mm:ss");
        }
    };
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(1000);
                //get()就可以从ThreadLocal获取DateFormat对象，并格式化时间
                String result = threadLocal.get().format(date);
                System.out.println("线程1 时间格式化 "+result);
            }
        });
        t1.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(2000);
                //get()就可以从ThreadLocal获取DateFormat对象，并格式化时间
                String result = threadLocal.get().format(date);
                System.out.println("线程2 时间格式化 "+result);
            }
        });
        t2.start();
    }
}
