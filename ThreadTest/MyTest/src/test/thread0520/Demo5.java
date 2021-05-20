package test.thread0520;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程安全的解决方案：
 *       ThreadLocal
 *           三个重要方法：set(T)将内容存储到ThreadLocal当中。（给线程存私有变量）
 *                       get()从线程中取私有变量
 *                       remove()从线程中移除私有变量
 */
public class Demo5 {
    //创建了一个ThreadLocal
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        //设置私有变量
        threadLocal.set(new SimpleDateFormat("mm:ss"));
        //得到ThreadLocal
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        Date date = new Date(1000);
        String res = simpleDateFormat.format(date);
        System.out.println("时间："+res);

    }
}
