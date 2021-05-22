package test.thread0518;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 【线程池的状态】
 */
public class Demo13线程池的状态 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5,5,60,
                        TimeUnit.SECONDS,new LinkedBlockingDeque<>(10));

        //看源码
        //RUNNING
        //SHUTDOWN
        //STOP
        //TIDYING
        //TERMINATED

    }
}
