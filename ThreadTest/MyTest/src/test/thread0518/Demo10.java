package test.thread0518;

import java.util.concurrent.*;

/**
 * 拒绝策略
 */
public class Demo10 {
    public static int count = 1;

    public static void main(String[] args) {
        //创建线程工厂的方式2
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("myThreadPool-"+(count++));
                return thread;
            }
        };

        //      拒绝策略【jdk有四种，自己可以定义一个。总共5种】

        //【1.默认】
        /*ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(1),threadFactory,new ThreadPoolExecutor.AbortPolicy());*/

        //【2.把当前的任务交给主线程执行】
        /*ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(1),threadFactory,new ThreadPoolExecutor.CallerRunsPolicy());*/

        //【3.丢弃最老的任务】
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,2,60, TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(8),threadFactory,new ThreadPoolExecutor.DiscardOldestPolicy());

        //【4.丢弃最新加入的任务】
//        ThreadPoolExecutor threadPoolExecutor =
//                new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,
//                        new LinkedBlockingDeque<>(8),threadFactory,new ThreadPoolExecutor.DiscardPolicy());

        //【5.自定义拒绝策略】
//        ThreadPoolExecutor threadPoolExecutor =
//                new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
//                        new LinkedBlockingDeque<>(8), threadFactory, new RejectedExecutionHandler() {
//                    @Override
//                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                        //自定义拒绝策略，可以写到日志、数据库、也可啥都不做
//                        System.out.println("执行了自定义拒绝策略");
//                    }
//                });


        //执行任务
        for (int i = 0; i <11 ; i++) {
            final int finalI = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI+"  线程名："+Thread.currentThread().getName());

                }
            });
        }
    }
}
