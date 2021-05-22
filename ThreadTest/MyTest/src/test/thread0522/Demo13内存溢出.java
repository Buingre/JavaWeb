package test.thread0522;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示【内存溢出】问题:
 *              【解决】remove
 * TODO:完成代码 81
 */
public class Demo13内存溢出 {
    private static ThreadLocal<MyThreadLocal> threadLocal = new ThreadLocal<>();

    //创建 大对象
    static class MyThreadLocal{
        private byte[] bytes = new byte[1*1024*1024];
    }
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));

    }


}
