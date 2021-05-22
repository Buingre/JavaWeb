package test.thread0522;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * 坑🕳：  当ThreadLocal有set时，不执行任何初始化方法
 * withInitial():
 * initialValue()；
 *
 * why？ （ThreadLocal的初始化方法什么时候不执行）
 *      TODO：源码讲解，过度设计
 *      “懒设计方法” ThreadLocal在执行get的时候才会判断并调用初始化，如果get前set了，那就不初始化了
 */
public class Demo6 {
    //创建了并初始化ThreadLocal

    private static ThreadLocal<String> threadLocal = new ThreadLocal(){
        @Override
        protected String initialValue() {
            System.out.println("执行initialValue方法 ");

            return Thread.currentThread().getName()+" java";
        }
    };
    /*private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(new Supplier<String>() {
        @Override
        public String get() {
            System.out.println("执行了withInitial方法");

            return Thread.currentThread().getName()+" java";
        }
    });*/
    public static void main(String[] args) {
        //使用线程池的方法演示
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                1,0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
        //执行任务
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                //set
                threadLocal.set(Thread.currentThread().getName()+" Mysql");
                //get ThreadLocal
                String res = threadLocal.get();
                System.out.println(Thread.currentThread().getName()+" 得到结果 "+res);
            }
        });

    }
}
