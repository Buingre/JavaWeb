package test.thread0522;

import java.text.SimpleDateFormat;

/**
 * ThreadLocal在不同线程设置值和取值
 */
public class Demo1演示ThreadLocal {
    //创建了一个ThreadLocal
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //定义公共任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String tname = Thread.currentThread().getName();
                System.out.println(tname+" 设置值： "+tname);
                //将名字设置到ThreadLocal
                try {
                    threadLocal.set(tname);
                    //执行threadLocal打印
                    printThreadLocal();
                } finally {
                    //TODO:移除ThreadLocal,否则会
                    threadLocal.remove();
                }
            }


        };

        Thread t1 = new Thread(runnable,"线程1");
        t1.start();
        Thread t2 = new Thread(runnable,"线程2");
        t2.start();
    }

    private static void printThreadLocal() {
        //
        String res = threadLocal.get();
        System.out.println(Thread.currentThread().getName()+" 中取值："+res);
    }
}
